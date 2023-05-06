package app.service;

import app.User;
import app.dao.UserDao;
import app.dao.UserDaoJDBC;
import app.util.UserUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDao userDao;
    public UserService(UserDao userDao){
        this.userDao=userDao;
    }


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
            bufferedWriter.write(user.isAvailable()+",");
            bufferedWriter.write(user.getDate()+"\n");
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public void updateChangedUser(BufferedReader bufferedReader,User user) throws IOException {
        UserUtils userUtils=new UserUtils();
        System.out.println("The " + user.getUsername() + "'s first name is " + user.getFirstName() + ". You can change it.");
        userUtils.setUserFirstName(bufferedReader, user);
        System.out.println("The " + user.getUsername() + "'s last name is " + user.getLastName() + ". You can change it.");
        userUtils.setUserLastName(bufferedReader, user);
        System.out.println("The " + user.getUsername() + "'s birthday is " + user.getDate() + ". You can change it.");
        userUtils.setUserBirthday(bufferedReader, user);
        System.out.println("The " + user.getUsername() + "'s phonenumber is " + user.getPhoneNumber() + ". You can change it.");
        userUtils.setPhoneNumber(bufferedReader, user);
        userDao.updateUser(user);
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
                        user.setId(Long.valueOf(usersToString[0]));
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

//    public List<User> loadUsersHib(){
//
//    }

}
