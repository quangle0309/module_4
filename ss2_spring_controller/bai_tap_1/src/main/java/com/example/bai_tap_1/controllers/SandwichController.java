package com.example.bai_tap_1.controllers;

import com.example.bai_tap_1.services.impl.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichController {
    @Autowired
    private SandwichService sandwichService;

    @GetMapping("/")
    public String showForm(Model model){
        String[] condiments = sandwichService.getAll();
        model.addAttribute("condiments", condiments);
        return "index";
    }

    @PostMapping("/sandwich")
    public String save(@RequestParam(defaultValue = "") String[] condiments, Model model, RedirectAttributes redirect) {
        if (condiments.length > 0) {
            model.addAttribute("condiments", condiments);
            return "list";
        } else {
            redirect.addFlashAttribute("message", "Không chọn khỏi ăn!");
            return "redirect:/";
        }
    }
}
