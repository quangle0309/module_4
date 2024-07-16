package com.example.dictionary.controllers;

import com.example.dictionary.services.impl.DictionaryService;
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

    @GetMapping("/dictionary")
    public String showDictionary() {
        return "home";
    }

    @PostMapping("/dictionary")
    public String resultDictionary(@RequestParam("english") String word, Model model) {

        String vietnamese = dictionaryService.findMeaning(word);
        model.addAttribute("english", word);
        if (vietnamese != null) {
            model.addAttribute("result", vietnamese);
        } else {
            model.addAttribute("result", "Word not found in dictionary.");
        } 
        return "home";
    }
}
