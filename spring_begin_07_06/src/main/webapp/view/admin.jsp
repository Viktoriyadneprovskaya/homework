<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<a href="/logout">Logout button</a>
    Welcome back, ADMIN <sec:authentication property="name"/>
<br/>
<a href="/users">Link to users</a></br>
<%--<sec:authorize access="hasAuthority('ADMIN')">--%>

<%--</sec:authorize>--%>
</br>

</body>
</html>
