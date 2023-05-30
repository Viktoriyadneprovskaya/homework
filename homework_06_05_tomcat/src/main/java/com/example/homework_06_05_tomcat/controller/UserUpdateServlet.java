package com.example.homework_06_05_tomcat.controller;

import com.example.homework_06_05_tomcat.dao.UserDaoImpl;
import com.example.homework_06_05_tomcat.model.command.UserUpdateCommand;
import com.example.homework_06_05_tomcat.model.error.ValidationError;
import com.example.homework_06_05_tomcat.util.UserCommandValidator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
    private final UserDaoImpl userDao;

    public UserUpdateServlet() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phonenumber");
        //LocalDate birthDate = LocalDate.parse(request.getParameter("date")); перевести в формат java и добавить в билдер

        UserUpdateCommand userUpdateCommand = UserUpdateCommand.builder()
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .phoneNumber(phoneNumber)
                //.date(birthDate)
                .build();
        Map<String,String> errors = UserCommandValidator.validateUserCommand(userUpdateCommand);
        if(errors.size()>0){
            request.getSession().setAttribute("id",id);
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("firstname",firstName);
            request.getSession().setAttribute("lastname",lastName);
            request.getSession().setAttribute("email",email);
            request.getSession().setAttribute("address",address);
            request.getSession().setAttribute("phonenumber",phoneNumber);
            //request.getSession().setAttribute("date",birthDate);// перевести в формат javascript и записать
            request.setAttribute("errors", errors);
            response.sendRedirect("users");
        }else{
            userDao.updateUserById(id, userUpdateCommand);
            response.sendRedirect("users");
        }


    }
}
