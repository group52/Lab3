<%--
  Created by IntelliJ IDEA.
  User: White Eagle
  Date: 09.05.2018
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
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
<h2>Entity Information</h2>
<form:form method = "POST" action = "saveEntity" modelAttribute="entity">
    <table>
        <form:hidden path="id"/>
        <tr>
            <td><form:label path = "Title">Title</form:label></td>
            <td><form:input path = "title" /></td>
        </tr>
        <tr>
            <td><form:label path = "parentId">Parent ID</form:label></td>
            <td><form:input path = "parentId" /></td>
        </tr>
        <tr>
            <td><form:label path = "entityType">Entity Type</form:label></td>
            <td><form:input path = "entityType" /></td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>


<h2>Entity List</h2>
<table border = "2" >
    <tr><th>ID</th><th>Name</th><th>Parent ID</th><th>Delete</th><th>Edit</th></tr>
    <c:forEach var = "entity" items = "${list}">
        <tr>
            <td>${entity.id}</td>
            <td><a href = "childEntity?id=${entity.id}">${entity.title}</a></td>
            <td>${entity.parentId}</td>
            <td><a href = "deleteEntity?id=${entity.id}"> delete </a></td>
            <td><a href = "editEntity?id=${entity.id}"> edit </a></td>
        </tr>
    </c:forEach>
</table>>
</form:form>

</body>
</html>
