package com.example.dictionary.services;

import com.example.dictionary.repositories.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService {
    @Autowired
    private DictionaryRepo dictionaryRepo;


    public Map<String, String> findAll() {
        return dictionaryRepo.findAll();
    }

    public String findMeaning(String word) {
        return dictionaryRepo.findMeaning(word);
    }
}
