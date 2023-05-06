package app.dao;

import app.User;

public interface UserDao {
    public boolean createUser(User user);

    public boolean updateUser(User user);

    public User findUserByUsername(String username);
    public User getUserByID(Long id);
    public void deleteUser(Long id);

}
