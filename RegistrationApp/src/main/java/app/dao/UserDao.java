package app.dao;

import app.User;

public interface UserDao {
    boolean createUser(User user);

    void updateUser(User user);

    User findUserByUsername(String username);
    User getUserByID(Long id);
    void deleteUser(Long id);

}
