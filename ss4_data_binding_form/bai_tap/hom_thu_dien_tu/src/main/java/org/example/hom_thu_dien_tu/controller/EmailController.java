package org.example.hom_thu_dien_tu.controller;


import org.example.hom_thu_dien_tu.model.EmailConfig;
import org.example.hom_thu_dien_tu.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping("/settings")
    public String showSettings(Model model) {
        model.addAttribute("config", emailService.getConfig());
        model.addAttribute("languages", List.of("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSizes", List.of(5, 10, 15, 25, 50, 100));
        return "settings";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("config") EmailConfig config, Model model) {
        emailService.updateConfig(config);
        model.addAttribute("config", config);
        return "result";
    }
}
