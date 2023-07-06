package com.example.spring_begin_07_06.service;

import com.example.spring_begin_07_06.dao.UserDao;
import com.example.spring_begin_07_06.exception.UserNotFoundException;
import com.example.spring_begin_07_06.model.User;
import com.example.spring_begin_07_06.model.command.UserUpdateCommand;
import com.example.spring_begin_07_06.util.UserFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    public void saveUser(User user){
        userDao.saveUser(user);
    }
    public void deleteUserById(Long id){
        userDao.deleteUserById(id);
    }
    public void updateUserById(Long id, UserUpdateCommand command){
        userDao.updateUserById(id,command);
    }
    public User getUserById(Long id){
        return userDao.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: "+ id + "hadn't been found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userDao.findUserByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException("User with "+ username + "hasn't been found"));
        return UserFactory.toSecurityUser(user);
    }
}
