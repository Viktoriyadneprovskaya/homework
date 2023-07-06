package com.example.spring_begin_07_06.dao;

import com.example.spring_begin_07_06.model.Role;

import java.util.Optional;

public interface RoleDao {
    Optional<Role>findRoleByName(String name);

}
