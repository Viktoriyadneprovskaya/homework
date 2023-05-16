package com.example.homework_06_05_tomcat.dao.impl;

import com.example.homework_06_05_tomcat.model.User;
import com.example.homework_06_05_tomcat.model.command.UserUpdateCommand;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void deleteUserById(Long id);
    void updateUserById(Long id,UserUpdateCommand command);
}
