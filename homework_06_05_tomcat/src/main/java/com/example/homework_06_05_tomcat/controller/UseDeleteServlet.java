package com.example.homework_06_05_tomcat.controller;

import com.example.homework_06_05_tomcat.dao.UserDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/delete")
public class UseDeleteServlet extends HttpServlet {
    private final UserDaoImpl userDao;

    public UseDeleteServlet(UserDaoImpl userDao) {

        this.userDao = new UserDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        userDao.deleteUserById(id);
        response.sendRedirect("users");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
