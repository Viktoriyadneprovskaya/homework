package com.example.homework_06_05_tomcat.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "users", schema = "regg_app")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    String username;
    String password;
    @Column(name = "lastname")
    String lastName;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "birth_date")
    LocalDate date;
    String email;
    @Column(name = "phonenumber")
    String phoneNumber;
    String address;
    @Column(name = "isavailable")
    boolean isAvailable;


}