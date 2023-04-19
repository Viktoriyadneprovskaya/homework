package app.service;

import app.User;
import app.dao.UserDao;

import java.io.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.*;
public class UserService {

    private final UserDao userDao= new UserDao();
    public boolean saveUser(User user){
        return userDao.createUser(user);
    }
    public void saveUser(User user,File file){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(user.getId()+",");
            bufferedWriter.write(user.getUsername()+",");
            bufferedWriter.write(user.getPassword()+",");
            bufferedWriter.write(user.getFirstName()+",");
            bufferedWriter.write(user.getLastName()+",");
            bufferedWriter.write(user.getEmail()+",");
            bufferedWriter.write(user.getPhoneNumber()+",");
            bufferedWriter.write(user.getIsAvailable()+",");
            bufferedWriter.write(user.getDate()+"\n");
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void editUserByUsername(User user){
        if(user==null){
            System.out.println("You entered null");
        }else {
            System.out.println("Your user has username "+ user.getUsername());
        }
    }
    public List<User> loadUsers(File file) {
        List<User> users = new ArrayList<>();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        String[] usersToString = line.split(",");
                        User user = new User();
                        user.setId(Integer.parseInt(usersToString[0]));
                        user.setUsername(usersToString[1]);
                        user.setPassword(usersToString[2]);
                        user.setFirstName(usersToString[3]);
                        user.setLastName(usersToString[4]);
                        user.setEmail(usersToString[5]);
                        user.setPhoneNumber(usersToString[6]);
                        user.setAvailable(Boolean.parseBoolean(usersToString[7]));
                        user.setDate(LocalDate.parse(usersToString[8]));
                        users.add(user);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return users;
    }

}
