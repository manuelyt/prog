package com.example.oauth247.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("name", principal.getAttribute("login"));
        model.addAttribute("avatar", principal.getAttribute("avatar_url"));
        return "welcome";
    }
}