package com.example.homework_06_05_tomcat.dao.impl;

import com.example.homework_06_05_tomcat.model.User;
import com.example.homework_06_05_tomcat.model.command.UserUpdateCommand;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    void createUser(User user);
    void deleteUserById(Long id);
    void updateUserById(Long id,UserUpdateCommand command);
}
