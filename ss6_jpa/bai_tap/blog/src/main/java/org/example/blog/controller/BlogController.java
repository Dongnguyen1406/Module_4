package org.example.blog.controller;

import org.example.blog.entity.Blog;
import org.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        blogService.delete(id);
        return "redirect:/blogs";
    }
}
