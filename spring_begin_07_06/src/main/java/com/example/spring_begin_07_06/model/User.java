package com.example.spring_begin_07_06.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.NamedQueries;
import org.springframework.format.annotation.DateTimeFormat;

@NamedQueries(
        {
                @NamedQuery(
                        name = "User.findByUserName",
                        query = "from User u where u.username = :username"
                )
        }

)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

@Entity
@Table(name = "users", schema = "regg_app")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long user_id;
    String username;
    String password;
    @Column(name = "lastname")
    String lastName;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    String email;
    @Column(name = "phonenumber")
    String phoneNumber;
    String address;
    @Column(name = "isavailable")
    boolean isAvailable;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private List<Role> roles;
}

