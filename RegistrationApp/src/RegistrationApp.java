import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
//TODO UserService;
public class RegistrationApp {

    RegistrationApp(){

    }
    public void runApp() {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[10];
        int userId = 1;
        boolean exit = true;
        while (exit) {
            System.out.println("Hello! You can register user here" +
                    "To create user press 1, to list all available users press 2, to exit press 3");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    User user = new User();
                    user.setId(userId);
                    setUserName(scanner, user);
                    setUserPassword(scanner, user);
                    setUserFirstLastName(scanner, user);
                    setUserBirthday(scanner, user);
                    setUserEmail(scanner, user);
                    setPhoneNumber(scanner, user);

                    users[userId - 1] = user;
                    userId++;
                    System.out.println("User is created");
                    System.out.println(user);
                    break;
                case 2:
                    for (int i = 0; i < userId - 1; i++) {
                        System.out.println(users[i].toString());
                    }
                    System.out.println();
                    break;
                case 3:
                    exit = false;
                    System.out.println("Thank you for using our application");
                    break;
                default:
                    System.out.println("Wrong action, choose correct one(1,2,3)");
                    break;
            }
        }
    }

    private void setUserName(Scanner scanner, User user) {
        System.out.println("Enter username in alpha-numeric format:");
        boolean check = true;
        while (check) {
            String userName = scanner.next();
            if (validateUsername(userName)) {
                user.setUsername(userName);
                check = false;
            } else {
                System.out.println("You entered wrong username, it must contain only alpha-numeric values:");
            }
        }
    }

    private void setUserPassword(Scanner scanner, User user) {
        System.out.println("Enter password with special symbols: !,@,#,$,%, min length of password is 4:");
        boolean check = true;
        while (check) {
            String password = scanner.next();
            if (validatePassword(password)) {
                user.setPassword(password);
                check = false;
            } else {
                System.out.println("You entered wrong password, enter correct one again: ");
            }
        }
    }

    private void setUserFirstLastName(Scanner scanner, User user) {
        System.out.println("Enter Firstname: ");
        String firstName = scanner.next();
        user.setFirstName(firstName);
        System.out.println("Enter Lastname: ");
        String lastName = scanner.next();
        user.setLastName(lastName);
    }

    private void setUserBirthday(Scanner scanner, User user) {
        System.out.println("Enter date in format dd.mm.yyyy: ");
        boolean check = true;
        while (check) {
            String date = scanner.next();
            if (validateDate(date)) {
                user.setDate(date);
                check = false;
            } else {
                System.out.println("You entered wrong date, enter correct one again: ");
            }
        }

    }

    private void setUserEmail(Scanner scanner, User user) {
        System.out.println("Enter email: ");
        boolean check = true;
        while (check) {
            String email = scanner.next();
            if (validateEmail(email)) {
                user.setEmail(email);
                check = false;
            } else {
                System.out.println("You entered wrong email, enter correct one again: ");
            }
        }
    }

    private void setPhoneNumber(Scanner scanner, User user) {
        System.out.println("Enter phone number: ");
        boolean check = true;
        while (check) {
            String phoneNumber = scanner.next();
            if (validatePhoneNumber(phoneNumber)) {
                user.setPhoneNumber(phoneNumber);
                check = false;
            } else {
                System.out.println("You entered wrong phone number, enter correct one again: ");
            }
        }
    }

    public static boolean validateUsername(String text) {
        String pattern = "[a-zA-Z0-9]{4,}";
        return text.matches(pattern);
    }

    //TODO RegEx
    public static boolean validatePassword(String password) {
        String pat = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{4,}";
        return (password.matches(pat));
    }

    public static boolean validateEmail(String email) {
        String pattern = "\\w+@[a-zA-Z]+\\.[a-zA-Z]+";
        return email.matches(pattern);
    }

    public static boolean validateDate(String date) {
        String pattern = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)";
        boolean ifMatch = date.matches(pattern);
        if (ifMatch) {
            DateValidator curDate = new DateValidator(date);
            if (!curDate.validateMonth()){
                return false;
            }
            if(!curDate.validateYear()){
                return false;
            }
            return true;
        }
        return false;
    }
    public boolean validatePhoneNumber(String number){
        return number.matches("^[+][0-9]{12}");
    }

    public static void main(String[] args) {
        RegistrationApp newApp = new RegistrationApp();
        newApp.runApp();
    }
}

