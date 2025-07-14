package org.example.ung_dung_tu_dien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DictionaryController {
    
    private static final Map<String, String> dictionary = new HashMap<>();
    
    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
    }
    
    @GetMapping("/")
    public String showForm(){
        return "index";
    }
    
    @PostMapping("/dictionary")
    public String dictionary(@RequestParam("search") String search,
                             Model model){
        String result = dictionary.get(search.toLowerCase());
        if (search != null){
            model.addAttribute("word", search);
            model.addAttribute("result", result);
        }
        return "result";
    }
}
