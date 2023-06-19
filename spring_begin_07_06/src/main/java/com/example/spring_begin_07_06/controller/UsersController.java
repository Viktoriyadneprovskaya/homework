package com.example.spring_begin_07_06.controller;

import com.example.spring_begin_07_06.model.User;
import com.example.spring_begin_07_06.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String handler(Model model){
        List<User> users = userService.getAllUsers();
       model.addAttribute("users", users);
        return "users";
    }
}
