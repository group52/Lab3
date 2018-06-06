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
<a href = "loginChange?id=${entity.id}"> Change Login </a>
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
        <tr>
            <td><form:label path = "entityType">Entity Type</form:label></td>
            <td><form:select path="entityType" cssStyle="width: 150px;">
                <option value="${entity.entityType}">Select(default ${entity.entityType})</option>
                <option value="0">0 - Entity</option>
                <option value="1">1 - University</option>
                <option value="2">2 - Tutor</option>
                <option value="3">3 - Group</option>
                <option value="4">4 - Student</option>
                <option value="5">5 - Subject</option>
                <option value="6">6 - Person</option>
                <option value="7">7 - User</option>
                <option value="8">8 - StudyLoad</option>
                <option value="9">9 - Parameter</option>
            </form:select><td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>

<a href = "viewAll"> View all entities </a>
<a href = "viewByType?entityType=5"> Subjects </a>
<a href = "viewByType?entityType=3"> Groups </a>
<a href = "viewByType?entityType=2"> Tutors </a>
<a href = "viewByType?entityType=9"> Parameters </a>
<h2>Entity List</h2>
<table border = "2" >
    <tr><th>ID</th><th>Name</th><th>Parent ID</th><th>Entity Type</th><th>Delete</th><th>Edit</th><th>Parameters</th></tr>
    <c:forEach var = "entity" items = "${list}">
        <tr>
            <td>${entity.id}</td>
            <td><a href = "childEntity?id=${entity.id}">${entity.title}</a></td>
            <td>${entity.parentId}</td>
            <td><a href = "viewByType?entityType=${entity.entityType}">${entity.entityType}</a></td>
            <td><a href = "deleteEntity?id=${entity.id}"> delete </a></td>
            <td><a href = "editEntity?id=${entity.id}"> edit </a></td>
            <td><a href = "paramEntity?id=${entity.id}"> parameters </a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
