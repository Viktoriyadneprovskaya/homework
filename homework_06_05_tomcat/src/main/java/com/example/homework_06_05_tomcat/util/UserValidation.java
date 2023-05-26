package com.example.homework_06_05_tomcat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserValidation {
    public boolean validateUsername (String text){
        return text.matches("[a-zA-Z0-9]{4,}");
    }
    public boolean validatePassword (String password){
        String pat = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{4,}";
        return (password.matches(pat));
    }
    public boolean validateEmail (String email){
        String pattern = "\\w+@[a-zA-Z]+\\.[a-zA-Z]+";
        return email.matches(pattern);
    }
    public boolean validateDate (String date){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        df.setLenient(false);
        try {
            df.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    public boolean validatePhoneNumber (String number){
        return number.matches("^[+][0-9]{12}");
    }


}
