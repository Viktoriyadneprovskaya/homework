<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/css/users.css">
    <title>Table of registered users</title>
</head>
<body>
<div class="wrapper">
    <div class="modal" id="modal">
        <div class="modal-form">
            <span class="close" id="modal-close">&times</span>
            <h2 class="title">Create new user for organisation</h2>
            <form action="users" method="post">
                <div class="aline-form">
                    <input type="text" name="username" class="edge" placeholder="Username" required>
                    <input type="text" name="password" class="edge" placeholder="Password" required>
                    <input type="text" name="firstname" class="edge" placeholder="First name" required>
                    <input type="text" name="lastname" class="edge" placeholder="Last name" required>
                    <input type="text" name="email" class="edge" placeholder="Email" required>
                    <input type="text" name="address" class="edge" placeholder="Address" required>
                    <input type="text" name="phonenumber" class="edge" placeholder="Phonenumber" required>
                    <input type="date" name="birthdate" class="edge" placeholder="Birthdate" required>
                    <button type="submit" class="edge">Save</button>
                </div>
            </form>
        </div>
    </div>

    <div class="modal" id="update-modal">
        <div class="modal-form">
            <span class="close" id="update-modal-close">&times</span>
            <h2 class="title">UpdateUser</h2>
            <form action="update" method="post">
                <div class="aline-form">
                    <input type="text" id="edit-id" name="id" hidden>
                    <input type="text" id="edit-username" name="username" class="edge" placeholder="Username" required>
                    <input type="text" id="edit-firstname" name="firstname" class="edge" placeholder="First name" required>
                    <input type="text" id="edit-lastname" name="lastname" class="edge" placeholder="Last name" required>
                    <input type="text" id="edit-email" name="email" class="edge" placeholder="Email" required>
                    <input type="text" id="edit-address" name="address" class="edge" placeholder="Address" required>
                    <input type="text" id="edit-phonenumber" name="phonenumber" class="edge" placeholder="Phonenumber" required>
                    <input type="date" id="edit-birthdate" name="birthdate" class="edge" placeholder="Birthdate" required>
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
            <th scope="col">#</th> <!-- это заголовок-->
            <th scope="col">User name</th>
            <th scope="col">Full name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Phone</th>
            <th scope="col">E-mail</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <C:forEach items="${users}" var="user">
            <tr><!-- это новая строка-->
                <th scope="row">${user.number}</th> <!-- это данные строки-->
                <td class="name">${user.username}</td>
                <td class="">${user.firstName} ${user.lastName}</td>
                <td>${user.date}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.email}</td>
                <td>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="button" class="btn btn-primary edit-btn">
                            onclick="openEditModal('${user.id}', '${user.username}', '${user.firstMame}', '${user.email}','${user.phoneNumber}','${user.date}', '${user.address}')">
                            <i class="bi bi-pen"></i>
                        </button>
                        <button type="button" class="btn btn-primary delete-btn">
                            <a href="delete?id=${user.id}">
                                <i class="bi bi-trash"></i></a>
                        </button>
                    </div>
                </td>
            </tr>
        </C:forEach>
        </tbody>
    </table>
</div>
<script src="/js/user.js"></script>
</body>
</html>
