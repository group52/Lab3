<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: White Eagle
  Date: 09.05.2018
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subjects</title>
</head>
    <body>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <h1>Subjects List</h1>
    <table border="2" width="70%" cellpadding="2">
        <tr><th>Id</th><th>Title</th><th>Edit</th><th>Delete</th></tr>
        <c:forEach var="subject" items="${list}">
            <tr>
                <td>${subject.id}</td>
                <td>${subject.title}</td>
                <td><a href="edit_subject/${subject.id}">Edit</a></td>
                <td><a href="remove_subject/${subject.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="add_subject.jsp">Add New Subject</a>
    </body>
</html>
