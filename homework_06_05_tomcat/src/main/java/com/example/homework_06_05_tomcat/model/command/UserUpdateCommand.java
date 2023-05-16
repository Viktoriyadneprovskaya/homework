package com.example.homework_06_05_tomcat.model.command;


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
    String username;
    String password;
    String lastName;
    String firstName;
    LocalDate date;
    String email;
    String phoneNumber;
    String address;
}
