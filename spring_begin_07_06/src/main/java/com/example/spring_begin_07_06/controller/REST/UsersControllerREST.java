//package com.example.spring_begin_07_06.controller.REST;
//
//import com.example.spring_begin_07_06.model.User;
//import com.example.spring_begin_07_06.service.UserService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//public class UsersControllerREST {
//    private final UserService userService;
//    public UsersControllerREST(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        List<User> users = userService.getAllUsers();
//        return users;
//    }
//}
