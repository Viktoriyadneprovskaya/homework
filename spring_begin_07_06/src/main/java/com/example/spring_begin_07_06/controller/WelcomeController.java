package com.example.spring_begin_07_06.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping(value = "/")
    public String init(Model model){
        return "index";
    }
}
