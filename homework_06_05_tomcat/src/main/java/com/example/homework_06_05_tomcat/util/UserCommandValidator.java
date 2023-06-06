package com.example.homework_06_05_tomcat.util;

import com.example.homework_06_05_tomcat.dao.UserDaoImpl;
import com.example.homework_06_05_tomcat.dao.impl.UserDao;
import com.example.homework_06_05_tomcat.model.command.UserUpdateCommand;
import com.example.homework_06_05_tomcat.model.error.ValidationError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Map;

public class UserCommandValidator {
    public  static Map<String,String> validateUserCommand(UserUpdateCommand updateCommand){
//        List<ValidationError> errors = new ArrayList<>();
        Map<String,String> errors = new HashMap<>();
        String username = updateCommand.getUsername();
        String firstName = updateCommand.getFirstName();
        String lastName = updateCommand.getLastName();
        String email = updateCommand.getEmail();
        String address = updateCommand.getAddress();
        //String date = updateCommand.getDate().toString();
        String phoneNumber = updateCommand.getPhoneNumber();

        if(!validateUsername(username)){
            //добавить проверку на уникальность, поиск юзернейма в базе
            errors.put("username","Username is not valid, enter at least 4 symbols");
        }
        if(!validateName(firstName)){
            errors.put("firstname","Firstname shouldn't be empty and should contain only characters");
        }
        if(!validateName(lastName)){
            errors.put("lastname","Lastname shouldn't be empty and should contain only characters");
        }
        if(!validateEmail(email)){
            errors.put("email","Enter correct email");
        }
//        if(!validateDate(date)){
//            errors.put("date","Enter correct email");
//        }
        if(!validatePhoneNumber(phoneNumber)){
            errors.put("phone","Enter correct phone number");
        }
        if(!validateAddress(address)){
            errors.put("address","Enter address");
        }
        return errors;
    }
    private static boolean validateUsername (String text){

        return text.matches("[a-zA-Z0-9]{4,}");
    }
    private static boolean validatePassword (String password){
        String pat = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{4,}";
        return (password.matches(pat));
    }
    private static boolean validateEmail (String email){
        String pattern = "\\w+@[a-zA-Z]+\\.[a-zA-Z]+";
        return email.matches(pattern);
    }
    private static boolean validateName (String text){
        return text.matches("[a-zA-Z]+");
    }
    private static boolean validateDate (String date){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        df.setLenient(false);
        try {
            df.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    private static boolean validatePhoneNumber (String number){
        return number.matches("^[+][0-9]{12}");
    }
    private static boolean validateAddress (String address){
        return !address.isEmpty();
    }


}
