package com.example.dictionary.services.impl;

import com.example.dictionary.repositories.impl.DictionaryRepo;
import com.example.dictionary.services.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private DictionaryRepo dictionaryRepo;

    @Override
    public Map<String, String> findAll() {
        return dictionaryRepo.findAll();
    }

    @Override
    public String findMeaning(String word) {
        return dictionaryRepo.findMeaning(word);
    }
}
