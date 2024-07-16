package com.example.bai_tap1.controllers;

import com.example.bai_tap1.models.EmailSetting;
import com.example.bai_tap1.services.impl.EmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailSettingController {

    @Autowired
    private EmailSettingService emailSettingService;

    @GetMapping("/settings")
    public String showForm(Model model) {
        model.addAttribute("emailSetting", new EmailSetting());
        return "display";
    }

    @PostMapping("/settings")
    public String submitForm(@ModelAttribute EmailSetting emailSetting, Model model) {
        emailSettingService.add(emailSetting);
        model.addAttribute("emailSetting", emailSetting);
        model.addAttribute("message", "Lưu thay đổi thành công!");
        return "display";
    }
}
