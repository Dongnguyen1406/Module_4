package org.example.ung_dung_tu_dien.service.impl;

import org.example.ung_dung_tu_dien.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
    }
    
    @Override
    public String translate(String englistWord) {
        return dictionary.get(englistWord.toLowerCase());
    }
}
