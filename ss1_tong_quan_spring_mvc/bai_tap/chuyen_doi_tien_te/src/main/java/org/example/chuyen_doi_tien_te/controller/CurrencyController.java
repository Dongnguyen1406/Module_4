package org.example.chuyen_doi_tien_te.controller;

import org.example.chuyen_doi_tien_te.service.impl.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("rate") String  rate,
                          @RequestParam("usd") String  usd,
                          Model model) {
        Double result = currencyService.convert(rate, usd);
        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);
        
        if (result != null){
            model.addAttribute("result", result);
        } else {
            model.addAttribute("error", "Vui lòng nhập số!");
        }
        

        return "result";
    }
}
