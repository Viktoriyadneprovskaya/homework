package app;

import app.dao.UserDao;
import app.dao.UserDaoHibernate;
import app.service.UserService;
import app.util.HibernateUtil;
import app.util.UserUtils;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;


//ToDo 1.Get a list of all the usernames in the list of Users.//Realised in method: loadUsers
//ToDo 2.Filter the list of User objects to only include users whose last name starts with "S". //Realised in method: filterByLastName
//ToDo 3.Get a list of all the User objects in the list that have an email address ending in ".com"//Realised in method: filterByMail
//ToDo 4.Get a list of all the User objects in the list that are available //Realised in method: showAvailable
//ToDo 5.Filter the list of User objects to only include users whose phoneNumber value is not null or empty,
// and convert the resulting list to a set.//Realised in method:showOnlyWithPhone
//ToDo 6.Group the User objects in the list by their firstName field (ignoring case),
// and then print sorting each group by their lastName field (ignoring case).//Realised in method: groupUsers
//Todo 7.Find the User objects in the list that have a firstName field that matches a given regular expression pattern,
// and return them sorted by their lastName field (ignoring case).
//Todo 8.Find the User object in the list with the earliest date field, and return a Map containing the id as key and birthdate as value of that object.
//ToDo 9.Find the User objects in the list that have a date field in the same year as a given date, and then group them by the month of their date field,
// and return a Map where the key is the month and the value is a list of User objects with that month.
public class RegistrationApp {

    public void runApp() {
        UserDaoHibernate userDaoHibernate = new UserDaoHibernate();
        File file = new File("users.txt");
        UserService userService = new UserService(userDaoHibernate);
        UserUtils userUtils = new UserUtils();
        List<User> users = userService.loadUsers(file);
        boolean exit = true;
        while (exit) {
            System.out.println("Hello! You can register user here" +
                    "To create user press 1, to list all available users press 2, to exit press 0");
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                int input = Integer.parseInt(bufferedReader.readLine());
                switch (input) {
                    case 1 -> {
                        User user = new User();
                        user.setId((long) users.size());
                        userUtils.fillUserFields(bufferedReader, user);
                        boolean result = userService.saveUser(user);
                        if (result) {
                            userService.saveUser(user, file);
                            users.add(user);
                            System.out.println("User is created");
                            System.out.println(user);
                        } else {
                            System.out.println("Wrong!!");
                        }
                    }
                    case 2 -> {
                        System.out.println("List of available users: ");
                        users.forEach(System.out::println);
                    }
                    case 12 -> {
                        User userBeforeEdit = userUtils.verifyUsername(bufferedReader);
                        userService.updateChangedUser(bufferedReader, userBeforeEdit);
                    }
                    case 3 -> {
                        System.out.println(userUtils.filterByLastName(users, "S"));
                    }
                    case 4 -> {
                        System.out.println(userUtils.filterCorrectMailEndingWithString(users, ".com"));
                    }
                    case 5 -> {
                        System.out.println(userUtils.showUsersLogins(users));
                    }
                    case 6 -> {
                        System.out.println(userUtils.showAvailable(users));
                    }
                    case 7 -> {
                        System.out.println(userUtils.showOnlyWithPhone(users));
                    }
                    case 8 -> {
                        Map<String, List<User>> mapUser = userUtils.groupUsers(users);
                        for (Map.Entry<String, List<User>> userElement : mapUser.entrySet()) {
                            System.out.println("----------------------------------------");
                            System.out.println(userElement.getKey());
                            for (User user : userElement.getValue()) {
                                System.out.println("   name: " + user.getFirstName());
                            }
                        }
                    }
                    case 9 -> {
                        System.out.println(userUtils.findByPattern(users, "[a-zA-Z]{3,}[0-9]{2,}"));
                    }
                    case 10 -> {
                        Map<Long, LocalDate> mapUser = userUtils.findEarliestDate(users);
                        System.out.println(mapUser);
                    }
                    case 11 -> {
                        LocalDate year = LocalDate.of(1986, 01, 01);
                        Map<Month, List<User>> sortedByMonthUsers = userUtils.filterByYearSortByMonth(users, year);
                        for (Map.Entry<Month, List<User>> userElement : sortedByMonthUsers.entrySet()) {
                            System.out.println(userElement.getKey() + "\n" + userElement.getValue());
                        }
                    }
                    case 0 -> {
                        exit = false;
                        System.out.println("Thank you for using our application");
                    }
                    default -> System.out.println("Wrong action, choose correct one(1,2,3)");
                }
            } catch (NumberFormatException exception) {
                System.out.println(exception.getStackTrace()[0].toString());
                System.out.println("Wrong action, choose correct one(1,2,3)");
                System.out.println("Let's repeat your action!\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        HibernateUtil.closeSessionFactoryConnection();
    }
}

