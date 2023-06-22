package com.example.spring_begin_07_06.dao.impl;

import com.example.spring_begin_07_06.model.User;
import com.example.spring_begin_07_06.model.command.UserUpdateCommand;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUserById(Long id);
    void updateUserById(Long id, UserUpdateCommand command);
}
