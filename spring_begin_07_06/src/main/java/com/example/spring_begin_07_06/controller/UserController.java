package com.example.spring_begin_07_06.controller;

import com.example.spring_begin_07_06.model.User;
import com.example.spring_begin_07_06.model.command.UserCommand;
import com.example.spring_begin_07_06.service.UserService;
import com.example.spring_begin_07_06.util.UserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/{username")
        public String load(@PathVariable Long id, @PathVariable String username, Model model){
        User user = userService.getUserById(id);
        UserCommand userCommand = UserFactory.userToCommand(user);
        model.addAttribute("user",userCommand);
            return "user";
        }
}
