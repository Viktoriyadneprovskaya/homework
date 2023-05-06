package app.dao;
import app.User;
import app.util.DbUtils;

import java.sql.*;

public class UserDaoJDBC implements UserDao {

        public boolean createUser(User user) {
            try(Connection connection= DbUtils.getConnection()) {
                String sql = """
                    insert into regg_app.users(username, password, firstname, lastname, birth_date, email)
                    values(?, ?, ?, ?, ?, ?)
                    """;
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getFirstName());
                pstmt.setString(4, user.getLastName());
                pstmt.setDate(5, Date.valueOf(user.getDate()));
                pstmt.setString(6, user.getEmail());
                int row = pstmt.executeUpdate();
                return row >= 1;
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public User findUserByUsername(String username){
            try(Connection connection= DbUtils.getConnection()) {
                String sql = """
                    select * from regg_app.users
                    where username=?
                    """;
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, username);
                ResultSet resultSet=pstmt.executeQuery();
                if(!resultSet.next()){
                    return null;
                }else {
                    User user = new User();
                    user.setUsername(resultSet.getString("username"));
                    user.setFirstName(resultSet.getString("firstname"));
                    user.setLastName(resultSet.getString("lastname"));
                    user.setDate(resultSet.getDate("birth_date").toLocalDate());
                    user.setPhoneNumber(resultSet.getString("phone_number"));
                    return user;
                }

            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override //need to check
    public User getUserByID(Long id) {
        try (Connection connection = DbUtils.getConnection()) {
            String sql = """
                    select * from regg_app.users                     
                    where user_id=?
                    """;
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,id);
            ResultSet resultSet = pstmt.executeQuery();
            if(!resultSet.next()){
                return null;
            }else {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setDate(resultSet.getDate("birth_date").toLocalDate());
                user.setPhoneNumber(resultSet.getString("phone_number"));
                return user;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override //need to check
    public void deleteUser(Long id) {
        try(Connection connection= DbUtils.getConnection()) {
            String sql = """
                   delete from regg_app.users
                    where user_id=?
                    """;
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,id);
            pstmt.executeUpdate();//I can make this method boolean and add row result
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUser(User user){
        try(Connection connection= DbUtils.getConnection()) {
            String sql = """
                    update regg_app.users                     
                    set firstname=?, lastname=?, birth_date=?, phone_number=?
                    where username=?
                    """;
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setDate(3, Date.valueOf(user.getDate()));
            pstmt.setString(4, user.getPhoneNumber());
            pstmt.setString(5, user.getUsername());
            int row = pstmt.executeUpdate();
            if (row > 0){
                System.out.println("Success! User is changed");
                return true;
            }else {
                System.out.println("Something wrong");
                return false;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

