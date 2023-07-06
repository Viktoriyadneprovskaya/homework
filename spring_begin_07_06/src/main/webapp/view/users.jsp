<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/css/users.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

    <title>Table of registered users</title>
</head>
<body>
<a href="/logout">Logout button</a>
<div class="wrapper">
    <div class="modal" id="modal">
        <div class="modal-form">
            <span class="close" id="modal-close">&times</span>
            <h2 class="title">Create new user for organisation</h2>
            <form action="users/save" method="post">
                <div class="aline-form">
                    <input type="text" name="username" id="username-input" class="edge" placeholder="Username"
                           onblur="usernameValidation()" required>
                    <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>
                    <input type="text" name="password" id="password-input" class="edge" placeholder="Password"
                           onblur="passwordValidation()" required>
                    <span class="error" id="error-password">Password</span>
                    <input type="text" name="firstName" id="firstname-input" class="edge" placeholder="First name"
                           onblur="firstNameValidation()" required>
                    <span class="error" id="error-firstname">Firstname shouldn't be empty and should contain only characters</span>
                    <input type="text" name="lastName" id="lastname-input" class="edge" placeholder="Last name"
                           onblur="lastNameValidation()" required>
                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>
                    <input type="text" name="email" id="email-input" class="edge" placeholder="Email"
                           onblur="emailValidation()" required>
                    <span class="error" id="error-email">Enter correct email</span>
                    <input type="text" name="address" id="address-input" class="edge" placeholder="Address"
                           onblur="addressValidation()" required>
                    <span class="error" id="error-address">Address shouldn't be empty</span>
                    <input type="text" name="phoneNumber" id="phone-input" class="edge" placeholder="Phonenumber"
                           onblur="phoneValidation()" required>
                    <span class="error" id="error-phone">Phonenumber should contain only numbers</span>
                    <input type="date" name="date" id="birthday-input" class="edge" placeholder="Birthdate"
                           onblur="birthdayValidation()" required>
                    <span class="error" id="error-birthday">Birthday is not valid</span>
                    <button type="submit" class="btn btn-light edge">Save</button>
                </div>
            </form>
        </div>
    </div>

    <div class="modal ${errors!=null ? 'm-visible' : ''}" id="edit-modal">
        <div class="modal-form">
            <span class="close" id="edit-modal-close">&times</span>
            <h2 class="title">Update existing user</h2>
            <form action="users/update" method="post">
                <div class="aline-form">
                    <input type="text" id="edit-id" name="user_id" value="${user_id !=null ? user_id : ''}" hidden>
                    <input type="text" name="username" id="username-edit-input"
                           value="${username  !=null ? username : ''}" class="edge"
                           placeholder="Username"
<%--                           onblur="usernameValidation()"--%>
                           required>
<%--                    <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>--%>
                    <span class="error ${errors['username'] != null ? 's-visible' : ''}" id="error-edit-username">Username is not valid, enter at least 4 symbols</span>
                    <input type="text" name="firstName" id="firstname-edit-input"
                           value="${firstName !=null ? firstName : ''}" class="edge"
                           placeholder="First name"
<%--                           onblur="firstNameValidation()"--%>
                           required>
<%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
                    <span class="error ${errors['firstname'] != null ? 's-visible' : ''}" id="error-edit-firstname">Firstname shouldn't be empty and should contain only characters</span>
                    <input type="text" name="lastName" id="lastname-edit-input"
                           value="${lastName  !=null ? lastName : ''}" class="edge"
                           placeholder="Last name"
<%--                           onblur="lastNameValidation()"--%>
                           required>
<%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
                    <span class="error ${errors['lastname'] != null ? 's-visible' : ''}" id="error-edit-lastname">Lastname shouldn't be empty and should contain only characters</span>
                    <input type="text" name="email" id="email-edit-input" value="${email  !=null ? email : ''}"
                           class="edge"
                           placeholder="Email"
<%--                           onblur="emailValidation()"--%>
                           required>
<%--                    <span class="error" id="error-email">Enter correct email</span>--%>
                    <span class="error ${errors['email'] != null ? 's-visible' : ''}" id="error-edit-email">Enter correct email</span>
                    <input type="text" name="address" id="address-edit-input" value="${address  !=null ? address : ''}"
                           class="edge"
                           placeholder="Address"
<%--                           onblur="addressValidation()"--%>
                           required>
<%--                    <span class="error" id="error-address">Address shouldn't be empty</span>--%>
                    <span class="error ${errors['address'] != null ? 's-visible' : ''}" id="error-edit-address">Address shouldn't be empty</span>
                    <input type="text" name="phonenumber" id="phone-edit-input"
                           value="${phoneNumber  !=null ? phoneNumber : ''}" class="edge"
                           placeholder="Phonenumber"
                           onblur="phoneValidation()"
                           required>
<%--                    <span class="error" id="error-phone">Phonenumber should contain only numbers</span>--%>
                    <span class="error ${errors['phone'] != null ? 's-visible' : ''}" id="error-edit-phone">Phonenumber should contain only numbers</span>
                    <input type="date" name="date" id="birthday-edit-input" value="${date  !=null ? date : ''}"
                           class="edge"
                           placeholder="Birthdate"
                           onblur="birthdayValidation()"
                           required>
<%--                    <span class="error" id="error-birthday">Birthday is not valid</span>--%>
                    <span class="error ${errors['date'] != null ? 's-visible' : ''}" id="error-edit-birthday">Enter correct birthdate</span>
                    <button type="submit" class="edge">Update</button>
                </div>
            </form>
        </div>
    </div>

    <div class="page">
        <h2 class="title">Table of registered users</h2>
    </div>
    <div class="buttonStyle float-right">
        <button type="button" class="btn btn-primary btn-lg " id="add-btn">+ Add User</button>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
<%--            <th scope="col">#</th> <!-- это заголовок-->--%>
            <th scope="col">User name</th>
            <th scope="col">Full name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Phone</th>
            <th scope="col">E-mail</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr><!-- это новая строка-->
<%--                <th scope="row">${user.number}</th> <!-- это данные строки-->--%>
                <td class="name">${user.username}</td>
                <td class="">${user.firstName} ${user.lastName}</td>
                <td>${user.date}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.email}</td>
                <td>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="button" class="btn btn-primary edit-btn"
                                onclick="openEditModal('${user.user_id}', '${user.username}', '${user.firstName}', '${user.lastName}', '${user.email}','${user.phoneNumber}','${user.date}', '${user.address}')">
                            <i class="bi bi-pen"></i>
                        </button>
                        <button type="button" class="btn btn-primary delete-btn">
                            <a href="users/delete?id=${user.user_id}">
                                <i class="bi bi-trash"></i></a>
                        </button>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="/js/users.js"></script>
</body>
</html>

