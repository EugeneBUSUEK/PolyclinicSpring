package com.example.polyclinic.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("message", "Открыта главная страница поликлиники");
        return "home";
    }
}
