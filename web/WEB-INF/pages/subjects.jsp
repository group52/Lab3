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
    <title>Title</title>
</head>
    <body>

    <table border = "2" >
        <tr><th>ID</th><th>Title</th></tr>
        <c:forEach var = "subject" items = "${list}">
            <tr>
                <td>${subject.id}</td>
                <td>${subject.title}</td>
            </tr>
        </c:forEach>
    </table>


    <h2>Add subject</h2>
    <form:form method = "POST" action = "addSubject">
        <table>
            <tr>
                <td><form:label path = "title">Title</form:label></td>
                <td><form:input path = "title" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type = "submit" value = "Submit"/>
                </td>
            </tr>
        </table>
    </form:form>

    <a href = "editSubject"> Edit subject </a>
    <a href = "removeSubject"> Remove subject </a>

    </body>
</html>
