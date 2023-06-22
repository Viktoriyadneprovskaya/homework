package com.example.spring_begin_07_06.controller;

import com.example.spring_begin_07_06.model.User;
import com.example.spring_begin_07_06.model.command.UserUpdateCommand;
import com.example.spring_begin_07_06.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    private final UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        UserUpdateCommand command = UserUpdateCommand.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .date(user.getDate())
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .build();
        userService.updateUserById(user.getId(), command);
        return "redirect:/users";
    }
}
