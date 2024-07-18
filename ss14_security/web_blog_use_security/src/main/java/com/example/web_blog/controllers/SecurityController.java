package com.example.web_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

//    @GetMapping("/login")
//    public String showPageLogin(@CookieValue(value = "username", defaultValue = "")String username,
//                                @CookieValue(value = "password", defaultValue = "") String password,
//                                Model model) {
//        System.out.println(username);
//        System.out.println(password);
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
//        return "security/login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam("username")String username,
//                        @RequestParam("password")String password,
//                        @RequestParam(value = "remember-me", defaultValue = "false")Boolean remember,
//                        HttpServletResponse response) {
////        Check đăng nhập
////        mặc định là đăng nhập thành công
//        if(remember) {
//            Cookie cookieUsername = new Cookie("username", username);
//            cookieUsername.setHttpOnly(true);
//            cookieUsername.setMaxAge(60*60*24);
//            response.addCookie(cookieUsername);
//            Cookie cookiePassword = new Cookie("password", password);
//            cookiePassword.setHttpOnly(true);
//            cookieUsername.setMaxAge(60*60*24);
//            response.addCookie(cookiePassword);
//        } else {
//
//        }
//        return "redirect:/student";
//    }

    @GetMapping(value = "/login")
    public String loginPage(Model model, @RequestParam(value = "error", defaultValue = "")String error) {
        model.addAttribute("error", error);
        return "security/login";
    }

    @GetMapping(value = "/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "security/logoutSuccessfulPage";
    }

}