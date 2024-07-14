package com.example.dictionary.repositories;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepo {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("pen", "bút");
        dictionary.put("book", "sách");
        dictionary.put("apple", "quả táo");
        dictionary.put("student", "học sinh");
        dictionary.put("library", "thư viện");
    }

    public Map<String, String> findAll() {
        return dictionary;
    }

    public String findMeaning(String word) {
        if (dictionary.containsKey(word)) {
            String value = dictionary.get(word);
            return value;
        }
        return null;
    }
}
