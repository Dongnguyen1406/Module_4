package org.example.ung_dung_tu_dien.controller;

import org.example.ung_dung_tu_dien.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {
    
    @Autowired
    private DictionaryService dictionaryService;
    
    @GetMapping("/")
    public String showForm(){
        return "index";
    }
    
    @PostMapping("/search")
    public String dictionary(@RequestParam("word") String word,
                             Model model){
        String result = dictionaryService.translate(word);
        model.addAttribute("word", word);
        if (result != null){
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "không tìm thấy!");
        }
        return "result";
    }
}
