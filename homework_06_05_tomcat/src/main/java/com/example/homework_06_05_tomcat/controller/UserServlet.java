package com.example.homework_06_05_tomcat.controller;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.homework_06_05_tomcat.dao.UserDaoImpl;
import com.example.homework_06_05_tomcat.model.User;
import com.example.homework_06_05_tomcat.model.command.UserCommand;
import com.example.homework_06_05_tomcat.util.HibernateUtil;
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
        setAndDeleteAttributesForUpdate(request);
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
    private void setAndDeleteAttributesForUpdate(HttpServletRequest request){
        Map<String,String> errors = (Map<String, String>) request.getSession().getAttribute("errors");
        if (errors !=null && !errors.isEmpty()) {
            Long id =(Long) request.getSession().getAttribute("id");
            String username =(String) request.getSession().getAttribute("username");
            String firstName =(String) request.getSession().getAttribute("firstName");
            String lastName =(String) request.getSession().getAttribute("lastName");
            String email =(String) request.getSession().getAttribute("email");
            String address =(String) request.getSession().getAttribute("address");
            String phoneNumber =(String) request.getSession().getAttribute("phoneNumber");
            //and date
            request.setAttribute("id", id);
            request.setAttribute("username", username);
            request.setAttribute("firstname", firstName);
            request.setAttribute("lastname", lastName);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            request.setAttribute("phone", phoneNumber);
            //and date

        }


    }
}