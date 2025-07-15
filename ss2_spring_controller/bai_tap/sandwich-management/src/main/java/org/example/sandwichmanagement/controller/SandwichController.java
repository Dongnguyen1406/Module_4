package org.example.sandwichmanagement.controller;

import org.example.sandwichmanagement.service.impl.CondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @Autowired
    private CondimentService condimentService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("condiments", condimentService.getCondimentList());
        return "index";
    }

    @PostMapping("/save")
    public String saveCondiments(@RequestParam(value = "condiment", required = false) String[] condiments,
                                 Model model) {
        model.addAttribute("selected", condiments);
        return "result";
    }
}
