package com.example.homework_06_05_tomcat.model.error;

public class ValidationError {
    String name;
    String description;

    public ValidationError(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
