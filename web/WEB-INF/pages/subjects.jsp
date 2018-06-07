<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Subjects</title>
</head>
    <body>
    <a href = "loginChange?id=${entity.id}"> Change Login </a>
    <h1>Subjects List</h1>
    <table border = "2" >
        <tr><th>ID</th><th>Name</th></tr>
        <c:forEach var = "entity" items = "${list}">
            <tr>
                <td>${entity.id}</td>
                <td><a href = "childEntity?id=${entity.id}">${entity.title}</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href = "enter"> Start page </a>
    </body>
</html>
