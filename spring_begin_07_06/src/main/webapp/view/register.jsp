<%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 25.06.2023
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register user</title>
  <link href="${pageContext.request.contextPath}/css/users.css" rel="stylesheet" media="screen">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

</head>
<body>
<%--  <div class="modal-form">--%>
    <h2 class="title">Welcome to registration page</h2>
    <form action="register" method="post">
      <div class="aline-form">
        <input type="text" name="username" id="username-input" class="edge" placeholder="Username"
               onblur="usernameValidation()" required>
        <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>
        <input type="text" name="password" id="password-input" class="edge" placeholder="Password"
               onblur="passwordValidation()" required>
        <span class="error" id="error-password">Invalid password</span>
        <input type="text" name="firstname" id="firstname-input" class="edge" placeholder="Firstname"
               onblur="firstNameValidation()" required>
        <span class="error" id="error-firstname">Firstname shouldn't be empty and should contain only characters</span>
        <input type="text" name="lastname" id="lastname-input" class="edge" placeholder="Lastname"
               onblur="lastNameValidation()" required>
        <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>
        <input type="text" name="email" id="email-input" class="edge" placeholder="Email"
               onblur="emailValidation()" required>
        <span class="error" id="error-email">Enter correct email</span>
        <input type="text" name="address" id="address-input" class="edge" placeholder="Address"
               onblur="addressValidation()" required>
        <span class="error" id="error-address">Address shouldn't be empty</span>
        <input type="text" name="phonenumber" id="phone-input" class="edge" placeholder="Phonenumber"
               onblur="phoneValidation()" required>
        <span class="error" id="error-phone">Phonenumber should contain only numbers</span>
        <input type="date" name="birthdate" id="birthday-input" class="edge" placeholder="Birthdate"
               onblur="birthdayValidation()" required>
        <span class="error" id="error-birthday">Birthday is not valid</span>
        <button type="submit" class="btn btn-light edge">Register</button>
<%--      </div>--%>
    </form>
  </div>
<script src="${pageContext.request.contextPath}/js/users.js"></script>
</body>
</html>
