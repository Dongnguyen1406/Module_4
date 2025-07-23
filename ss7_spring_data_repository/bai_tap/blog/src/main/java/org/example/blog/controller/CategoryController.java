package org.example.blog.controller;

import org.example.blog.entity.Blog;
import org.example.blog.entity.Category;
import org.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs/categorys")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        return "list-category";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("category", new Category());
        return "create-category";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("message", "create successfull!");
        return "redirect:/blogs/categorys";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "update-category";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirect) {
        boolean isSuccess = categoryService.update(category);
        if (isSuccess) {
            redirect.addFlashAttribute("message", "update success!");
        } else {
            redirect.addFlashAttribute("error", "update fail!");
        }
        return "redirect:/blogs/categorys";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        boolean isDelete = categoryService.delete(id);
        if (isDelete) {
            redirect.addFlashAttribute("message", "delete success!");
        } else {
            redirect.addFlashAttribute("error", "delete fail!");
        }
        return "redirect:/blogs/categorys";
    }
}
