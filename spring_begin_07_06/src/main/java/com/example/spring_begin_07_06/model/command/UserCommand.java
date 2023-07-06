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
    private String username;
    private String lastName;
    private String firstName;
    private LocalDate date;
    private String email;
    private String phoneNumber;
    private String address;


}
