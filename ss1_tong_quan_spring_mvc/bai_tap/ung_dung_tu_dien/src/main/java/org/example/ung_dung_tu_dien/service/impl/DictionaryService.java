package org.example.ung_dung_tu_dien.service.impl;

import org.example.ung_dung_tu_dien.repository.DictionaryRepo;
import org.example.ung_dung_tu_dien.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    private final DictionaryRepo dictionaryRepo;

    @Autowired
    public DictionaryService(DictionaryRepo dictionaryRepo) {
        this.dictionaryRepo = dictionaryRepo;
    }

    @Override
    public String translate(String englishWord) {
        return dictionaryRepo.translate(englishWord);
    }
}
