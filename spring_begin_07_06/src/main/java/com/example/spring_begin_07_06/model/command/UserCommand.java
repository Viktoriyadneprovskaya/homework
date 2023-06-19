package com.example.spring_begin_07_06.model.command;

import com.example.spring_begin_07_06.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UserCommand {
    private Long id;
    private int number;
    private String username;
    private String lastName;
    private String firstName;
    private LocalDate date;
    private String email;
    private String phoneNumber;
    private String address;

    public static UserCommand userToCommand(User user) {
        return UserCommand.builder()
                .id(user.getId())
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
            command.setNumber(i + 1);
            userCommand.add(command);
        }
        return userCommand;
    }
}
