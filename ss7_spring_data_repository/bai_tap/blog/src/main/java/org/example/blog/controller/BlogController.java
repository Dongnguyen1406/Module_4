package org.example.blog.controller;

import org.example.blog.entity.Blog;
import org.example.blog.service.BlogService;
import org.example.blog.service.CategoryService;
import org.example.blog.service.IBlogService;
import org.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "sort", defaultValue = "title") String sortField,
                        @RequestParam(name = "dir", defaultValue = "desc") String sortDir,
                        @RequestParam(required = false) String keyword,
                        @RequestParam(required = false) Integer categoryId) {
        int size = 2;
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        PageRequest pageable = PageRequest.of(page, size, sort);

        Page<Blog> blogPage = blogService.searchBlogs(keyword, categoryId, pageable);

        model.addAttribute("blogs", blogPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("categorys", categoryService.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categorys", categoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "create successfull!");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Integer id, Model model, RedirectAttributes redirect) {
        if (blogService.findById(id) != null) {
            model.addAttribute("blog", blogService.findById(id));
            model.addAttribute("categorys", categoryService.findAll());
            return "view";
        }
        redirect.addFlashAttribute("message", "not found!");
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categorys", categoryService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        boolean isSuccess = blogService.update(blog);
        if (isSuccess) {
            redirect.addFlashAttribute("message", "update success!");
        } else {
            redirect.addFlashAttribute("error", "update fail!");
        }
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        boolean isDelete = blogService.delete(id);
        if (isDelete) {
            redirect.addFlashAttribute("message", "delete success!");
        } else {
            redirect.addFlashAttribute("error", "delete fail!");
        }
        return "redirect:/blogs";
    }
}
