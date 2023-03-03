package app.util;

import app.User;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserUtils {
    public void fillUserFields(BufferedReader bufferedReader, User user) throws IOException {
        setUserName(bufferedReader, user);
        setUserPassword(bufferedReader, user);
        setUserFirstName(bufferedReader, user);
        setUserLastName(bufferedReader, user);
        setUserBirthday(bufferedReader, user);
        setUserEmail(bufferedReader, user);
        setPhoneNumber(bufferedReader, user);
        setUserAvailable(bufferedReader, user);
    }

    public void setUserName(BufferedReader bufferedReader, User user) throws IOException {
        System.out.println("Enter username in alpha-numeric format: ");
        boolean check = true;
        while (check) {

            String username = bufferedReader.readLine();
            if (validateUsername(username)) {
                user.setUsername(username);
                check = false;
            } else {
                System.out.println("You entered wrong username, it must contain only alpha-numeric values");
            }
        }
    }

    public void setUserPassword(BufferedReader bufferedReader, User user) throws IOException {
        System.out.println("Enter password with special symbols: !,@,#,$,%, min length of password is 4:");
        boolean check = true;
        while (check) {
            String password = bufferedReader.readLine();
            if (validatePassword(password)) {
                user.setPassword(password);
                check = false;
            } else {
                System.out.println("You entered wrong password, enter correct one again: ");
            }
        }
    }

    public void setUserBirthday(BufferedReader bufferedReader, User user) throws IOException {
        System.out.println("Enter date in format ММ/dd/yyyy: ");
        boolean check = true;
        while (check) {
            String stringDate = bufferedReader.readLine();
            if (validateDate(stringDate)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate date = LocalDate.parse(stringDate, formatter);
                user.setDate(date);
                check = false;
            } else {
                System.out.println("You entered wrong date, enter correct one again: ");
            }
        }
    }

    public void setUserEmail(BufferedReader bufferedReader, User user) throws IOException {
        System.out.println("Enter email: ");
        boolean check = true;
        while (check) {
            String email = bufferedReader.readLine();
            if (validateEmail(email)) {
                user.setEmail(email);
                check = false;
            } else {
                System.out.println("You entered wrong email, enter correct one again: ");
            }
        }
    }

    public void setUserAvailable(BufferedReader bufferedReader, User user) throws IOException {
        Random rd = new Random();
        boolean isAvailable = rd.nextBoolean();
        user.setAvailable(isAvailable);
    }

    public void setUserFirstName(BufferedReader bufferedReader, User user) throws IOException {
        System.out.println("Enter Firstname: ");
        String firstName = bufferedReader.readLine();
        user.setFirstName(firstName);
    }

    public void setUserLastName(BufferedReader bufferedReader, User user) throws IOException {
        System.out.println("Enter Lastname: ");
        String lastName = bufferedReader.readLine();
        user.setLastName(lastName);
    }

    public void setPhoneNumber(BufferedReader bufferedReader, User user) throws IOException {
        System.out.println("Enter phone number: ");
        boolean check = true;
        while (check) {
            String phoneNumber = bufferedReader.readLine();
            if (validatePhoneNumber(phoneNumber)) {
                user.setPhoneNumber(phoneNumber);
                check = false;
            } else {
                System.out.println("You entered wrong phone number, enter correct one again: ");
            }
        }
    }

    public boolean validateUsername(String text) {
        return text.matches("[a-zA-Z0-9]{4,}");
    }

    public  boolean validatePassword(String password) {
        String pat = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{4,}";
        return (password.matches(pat));
    }

    public  boolean validateEmail(String email) {
        String pattern = "\\w+@[a-zA-Z]+\\.[a-zA-Z]+";
        return email.matches(pattern);
    }

    public boolean validateDate(String date) {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        df.setLenient(false);
        try {
            df.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public boolean validatePhoneNumber(String number) {
        return number.matches("^[+][0-9]{12}");
    }

    //task #1
    public List<String> showUsersLogins(List<User> users) {
        return users.stream()
                .map(user -> user.getUsername())
                .toList();
    }

    //task #2
    public List<User> filterByLastName(List<User> users, String S) {
        return users.stream()
                .filter(user -> user.getLastName().startsWith(S))
                .toList();
    }

    //task #3
    public List<User> filterCorrectMailEndingWithString(List<User> users, String S) {
        return users.stream()
                .filter(user -> user.getEmail().endsWith(S))
                .toList();
    }

    public List<User> showAvailable(List<User> users) {
        return users.stream()
                .filter(User::getIsAvailable)
                .collect(Collectors.toList());
    }

    public List<User> showOnlyWithPhone(List<User> users) {
        return users.stream().filter(user -> user.getPhoneNumber() != null)
                .filter(user -> user.getPhoneNumber() != "")
                .toList();
    }

    public Map<String, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getLastName)
                        .thenComparing(User::getFirstName))
                .collect(Collectors.groupingBy(User::getLastName));
    }

    public List<User> findByPattern(List<User> users, String patternStr) {
        return users.stream()
                .filter(user -> user.getUsername().matches(patternStr))
                .sorted(Comparator.comparing(User::getLastName))
                .toList();
    }

    public Map<Integer, LocalDate> findEarliestDate(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getDate))
                .findFirst()
                .stream()
                .collect(Collectors.toMap(User::getId, User::getDate));
    }

    public Map<Month, List<User>> filterByYearSortByMonth(List<User> users, LocalDate year) {
        return users.stream()
                .filter(user -> user.getDate().getYear() == year.getYear())
                .toList()
                .stream()
                .collect(Collectors.groupingBy(user -> user.getDate().getMonth()));

    }

}
