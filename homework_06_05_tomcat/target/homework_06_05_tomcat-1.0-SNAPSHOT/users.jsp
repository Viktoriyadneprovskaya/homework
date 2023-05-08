<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./src/main/resources/css/mainStyle.css"/>
    <meta charset="UTF-8">
    <title>Table of registered users</title>
</head>
<body>
<div class="wrapper">
    <div class="page">
        <h2 class="title">Table of registered users</h2>
    </div>
    <div class="buttonStyle float-right"><button type="button" class="btn btn-primary btn-lg ">+ Add User</button></div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">#</th> <!-- это заголовок-->
            <th scope="col">User name</th>
            <th scope="col">First Last name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Phone</th>
            <th scope="col">E-mail</th>
            <th scope="col">Status</th>
            <th scope="col">Action</th>
        </tr>
        </thead>

        <tbody>
        <C:forEach items="${users}" var="user">
        <tr><!-- это новая строка-->
            <th scope="row">1</th> <!-- это данные строки-->
            <td>${user.username}</td>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.date}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.email}</td>
            <td><i class="bi bi-check-circle"></i></td>
            <td><div class="btn-group" role="group" aria-label="Basic example">
                <button type="button" class="btn btn-primary"><i class="bi bi-pen"></i></button>
                <button type="button" class="btn btn-primary"><i class="bi bi-trash"></i></button>
            </div>
            </td>
        </tr>
        </C:forEach>
        </tbody>

    </table>
</div>

</body>
</html>
