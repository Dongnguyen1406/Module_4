package org.example.validate_form_dang_ky.controller;

import org.example.validate_form_dang_ky.dto.UserDto;
import org.example.validate_form_dang_ky.entity.User;
import org.example.validate_form_dang_ky.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
public class FormController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "index";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        model.addAttribute("user", user);
        model.addAttribute("message", "Create Successfully!");
        return "result";
    }

}
