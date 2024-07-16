package com.example.dictionary.services;

import java.util.Map;

public interface IDictionaryService {

    Map<String, String> findAll();

    String findMeaning(String word);
}
