package com.example.money_conversion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConversionController {

    @GetMapping("/home")
    public String showConversion() {
        return "home";
    }

    @PostMapping("/conversion")
    public String convert(@RequestParam("usd") double usd,
                          @RequestParam("rate") double rate, Model model) {

        double vndAmount = usd * rate;

        model.addAttribute("vndAmount", vndAmount);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "home";
    }
}
