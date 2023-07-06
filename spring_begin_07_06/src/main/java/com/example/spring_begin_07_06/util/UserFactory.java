package com.example.spring_begin_07_06.util;

import com.example.spring_begin_07_06.model.Role;
import com.example.spring_begin_07_06.model.SecurityUser;
import com.example.spring_begin_07_06.model.User;
import com.example.spring_begin_07_06.model.command.UserCommand;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserFactory {
    public static SecurityUser toSecurityUser(User user){
        return new SecurityUser(user.getUsername(), user.getPassword(), getAuthoritiesFromRoles(user.getRoles()), user.getUser_id());
    }
    public static List<GrantedAuthority> getAuthoritiesFromRoles(List<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public static UserCommand userToCommand(User user) {
        return UserCommand.builder()
                .id(user.getUser_id())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .date(user.getDate())
                .build();
    }

    public static List<UserCommand> usersToCommand(List<User> users) {
        List<UserCommand> userCommand = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            UserCommand command = userToCommand(users.get(i));
            userCommand.add(command);
        }
        return userCommand;
    }
}
