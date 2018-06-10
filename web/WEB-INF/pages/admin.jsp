<%--
  Created by IntelliJ IDEA.
  User: shen
  Date: 09.06.2018
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Admin</title>
</head>
<body>
<form:form id="adminForm" modelAttribute="user" action="adminProcess" method="post">
    <table align="center">
        <tr>
            <td>
                <form:label path="username">Username: </form:label>
            </td>
            <td>
                <form:input path="username" name="username" id="username" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="role">Role:</form:label>
            </td>
            <td>
                <form:input path="role" name="role" id="role" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td align="left">
                <form:button id="submit" name="submit">submit</form:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href="index.jsp">Home</a>
            </td>
        </tr>
    </table>
</form:form>
</table>
</body>
</html>
