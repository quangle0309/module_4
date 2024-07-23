package com.example.register_form.controllers;

import com.example.register_form.dto.UserDTO;
import com.example.register_form.models.User;
import com.example.register_form.services.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        model.addAttribute("isSubmitted", false);
        return "index";
    }

    @PostMapping("save")
    public String save (@Validated
                        @ModelAttribute UserDTO userDTO,
                        BindingResult bindingResult,
                        Model model) {
        model.addAttribute("isSubmitted", true);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("userDTO", userDTO);
            return "index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.save(user);
        model.addAttribute("messageCreate", "Đăng ký thành công!");
        return "success";
    }
}
