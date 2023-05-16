package com.example.homework_06_05_tomcat.controller;

import com.example.homework_06_05_tomcat.dao.UserDaoImpl;
import com.example.homework_06_05_tomcat.model.command.UserUpdateCommand;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
    private final UserDaoImpl userDao;

    public UserUpdateServlet(UserDaoImpl userDao) {

        this.userDao = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id =Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phonenumber");
        LocalDate birthDate = LocalDate.ofEpochDay(request.getDateHeader("date"));

        UserUpdateCommand userUpdateCommand = UserUpdateCommand.builder()
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .phoneNumber(phoneNumber)
                .date(birthDate)
                .build();

        userDao.updateUserById(id,userUpdateCommand);
        response.sendRedirect("users");
    }
}
