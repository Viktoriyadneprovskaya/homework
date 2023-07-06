package com.example.spring_begin_07_06.controller;

import com.example.spring_begin_07_06.dao.RoleDao;
import com.example.spring_begin_07_06.model.Role;
import com.example.spring_begin_07_06.model.User;
import com.example.spring_begin_07_06.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserService userService, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    public String showPage(){
        return "register";
    }

    @PostMapping
    public String register(@ModelAttribute("user") User user){
        Optional<Role> role = roleDao.findRoleByName("USER");
        user.setRoles(List.of(role.get()));
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userService.saveUser(user);
        return "redirect:login";
    }
}
