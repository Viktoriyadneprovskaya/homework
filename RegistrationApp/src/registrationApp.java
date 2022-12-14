import java.util.Date;
import java.util.Scanner;
//TODO UserService;
public class registrationApp {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        User[] users=new User[10];
        int userId=1;
        boolean exit=true;
        while (exit){
            System.out.println("Hello! You can register user here" +
                    "To create user press 1, to list all available users press 2, to exit press 3");
            int input=scanner.nextInt();
            switch (input){
                case 1:
                    User user=new User();
                    user.setId(userId);
                    System.out.println("Enter username in alpha-numeric format:");
                    boolean check=true;
                    while (check){
                        String userName= scanner.next();
                        if (validateUsername(userName)) {
                            user.setUsername(userName);
                            check=false;
                        }else {
                            System.out.println("You entered wrong username, it must contain only alpha-numeric values:");
                        }
                    }
                    System.out.println("Enter password with special symbols: !,@,#,$,%, min length of password is 4:");
                    check=true;
                    while (check){
                        String password=scanner.next();
                        if(validatePassword(password)){
                            user.setPassword(password);
                            check=false;
                        }else {
                            System.out.println("You entered wrong password, enter correct one again: ");
                        }
                    }
                    check=true;
                    //System.out.println("Enter Firstname: ");
                    //String firstName=scanner.next();
                    //System.out.println("Enter birth date in format mm/dd/yyyy");
                    //String stringDate=scanner.next();
                    //System.out.println("Enter Lastname: ");
                    //String lastName=scanner.next();
                    //Date date=new Date(stringDate);
                    System.out.println("Enter email: ");
                    while (check){
                        String email=scanner.next();
                        if(validateEmail(email)){
                            user.setEmail(email);
                            check=false;
                        }else {
                            System.out.println("You entered wrong email, enter correct one again: ");
                        }
                    }
                    check=true;
                    //System.out.println("Enter phone number: ");
                    //Date date=new Date(stringDate);
                    System.out.println("Enter date in format dd.mm.yyyy: ");
                    while (check){
                        String date=scanner.next();
                        if(validateDate(date)){
                            user.setDate(date);
                            check=false;
                        }else {
                            System.out.println("You entered wrong date, enter correct one again: ");
                        }
                    }
                    check=true;

                    users[userId-1]=user;
                    userId++;
                    System.out.println("User is created");
                    System.out.println(user);
                    break;
                case 2:
                    for (int i=0; i<userId-1; i++){
                        System.out.println(users[i].toString());
                    }
                    System.out.println();
                    break;
                case 3:
                    exit=false;
                    System.out.println("Thank you for using our application");
                    break;
                default:
                    System.out.println("Wrong action, choose correct one(1,2,3)");
                    break;
            }
        }
    }
    public static boolean validateUsername(String password){
        String pattern = "[a-zA-Z0-9]{4,}";
        return password.matches(pattern);
    }
    //TODO RegEx
    public static boolean validatePassword(String password){
        char[] symbolsArray = new  char[]{'!','@','#','$','%'};
        char[] passwordChars = password.toCharArray();
        if(password.length()<4){
            return false;
        }else {
            for (int i=0; i<passwordChars.length;i++){
                for (int j=0;j<symbolsArray.length;j++){
                    if(passwordChars[i]==symbolsArray[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean validateEmail(String password){
        String pattern = "[A-Za-z0-9+_.-]+@(.+)$";
        return password.matches(pattern);
    }
    public static boolean validateDate(String password){
        String pattern = "^(3[01]|[12][0-9]0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        return password.matches(pattern);
    }
}
