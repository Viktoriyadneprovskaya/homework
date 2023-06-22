package com.example.spring_begin_07_06.model.command;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class UserUpdateCommand {
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private LocalDate date;
    private String email;
    private String phoneNumber;
    private String address;
}

