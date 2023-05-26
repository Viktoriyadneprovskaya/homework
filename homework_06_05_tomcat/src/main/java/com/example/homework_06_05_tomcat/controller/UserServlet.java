package com.example.homework_06_05_tomcat.controller;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

import com.example.homework_06_05_tomcat.dao.UserDaoImpl;
import com.example.homework_06_05_tomcat.model.User;
import com.example.homework_06_05_tomcat.model.command.UserCommand;
import com.example.homework_06_05_tomcat.util.HibernateUtil;
import com.example.homework_06_05_tomcat.util.UserValidation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet(name = "users-servlet", value = "/users")
public class UserServlet extends HttpServlet {

    private final UserDaoImpl userDao;

    public UserServlet() {

        this.userDao = new UserDaoImpl();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> dbusers = userDao.getAllUsers();
        List<UserCommand> usersCommand = UserCommand.usersToCommand(dbusers);

        request.setAttribute("users", usersCommand);
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String password =request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phonenumber");
        LocalDate birthDate = LocalDate.ofEpochDay(request.getDateHeader("date"));
        User user = User.builder()
                .username(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .phoneNumber(phoneNumber)
                .date(birthDate)
                .build();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        response.sendRedirect("users");
    }

    public void destroy() {
    }
}