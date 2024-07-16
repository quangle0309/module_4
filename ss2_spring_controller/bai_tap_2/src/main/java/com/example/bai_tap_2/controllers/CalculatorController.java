package com.example.bai_tap_2.controllers;

import com.example.bai_tap_2.services.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String showForm() {
        return "home";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam (defaultValue = "0") String firstNumber,
                             @RequestParam (defaultValue = "0") String lastNumber,
                             @RequestParam String operator,
                             Model model) {

        try {
            double num1 = Double.parseDouble(firstNumber);
            double num2 = Double.parseDouble(lastNumber);
            double result = calculatorService.calculate(num1, num2, operator);
            model.addAttribute("result", result);
        }
        catch (NumberFormatException e){
            model.addAttribute("error", "Vui lòng nhập số!");
        }
        catch (ArithmeticException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "home";
    }
}
