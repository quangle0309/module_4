package com.example.dictionary.repositories;

import java.util.Map;

public interface IDictionaryRepo {
    Map<String, String> findAll();

    String findMeaning(String word);
}
