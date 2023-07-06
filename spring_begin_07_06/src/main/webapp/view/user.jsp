<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>User page</title>
</head>
<body>
<a href="/logout">Logout button</a>
Welcome back, ADMIN <sec:authentication property="name"/>
</br>
${user.firstName}
${user.lastName}
${user.email}
${user.address}
${user.phoneNumber}
</br>
</body>
</html>
