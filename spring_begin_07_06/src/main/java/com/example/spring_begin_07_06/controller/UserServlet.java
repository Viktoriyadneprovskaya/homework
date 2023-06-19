//package com.example.spring_begin_07_06.controller;
//
//import com.example.spring_begin_07_06.dao.UserDaoImpl;
//import com.example.spring_begin_07_06.model.User;
//import com.example.spring_begin_07_06.model.command.UserCommand;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//@WebServlet("/users")
//public class UserServlet extends HttpServlet {
//    private final UserDaoImpl userDao;
//
//    public UserServlet() {
//        this.userDao = new UserDaoImpl();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        setAndDeleteAttributesForUpdate(request);
//        List<User> dbUsers = userDao.getAllUsers();
//        List<UserCommand> usersCommand = UserCommand.usersToCommand(dbUsers);
//
//        request.setAttribute("users", usersCommand);
//        request.getRequestDispatcher("users.jsp").forward(request,response);
//    }
//
//    private void setAndDeleteAttributesForUpdate(HttpServletRequest request) {
//        Map<String,String> errors =(Map<String, String>) request.getSession().getAttribute("errors");
//        if(errors != null && !errors.isEmpty()){
//            Long id = (Long) request.getSession().getAttribute("id");
//            String username = (String) request.getSession().getAttribute("username");
//            String password = (String) request.getSession().getAttribute("password");
//            String firstName = (String) request.getSession().getAttribute("firstName");
//            String lastName = (String) request.getSession().getAttribute("lastName");
//            String email = (String) request.getSession().getAttribute("email");
//            request.setAttribute("id",id);
//            request.setAttribute("username",username);
//            request.setAttribute("password",password);
//            request.setAttribute("firstname",firstName);
//            request.setAttribute("lastname",lastName);
//            request.setAttribute("email",email);
//            request.setAttribute("errors",errors);
//            request.getSession().removeAttribute("id");
//            request.getSession().removeAttribute("username");
//            request.getSession().removeAttribute("password");
//            request.getSession().removeAttribute("firstName");
//            request.getSession().removeAttribute("lastName");
//            request.getSession().removeAttribute("email");
//            request.getSession().removeAttribute("errors");
//
//        }
//    }
//}
