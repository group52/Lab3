<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Login page</h2>
<form:form method = "POST" action = "checkLogin" modelAttribute="loginPassword">
<table>
    <form:hidden path = "userId"/>
    <tr>
        <td><form:label path = "login">Login</form:label></td>
        <td><form:input path = "login" /></td>
    <tr>
        <td><form:label path = "password">Password</form:label></td>
        <td><form:input path = "password" /></td>
    </tr>
    <tr>
        <td colspan = "2">
            <input type = "submit" value = "Submit"/>
        </td>
    </tr>
</table>
</form:form>



</html>
