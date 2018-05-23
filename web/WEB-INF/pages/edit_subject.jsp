<%--
  Created by IntelliJ IDEA.
  User: White Eagle
  Date: 23.05.2018
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Subject</title>
</head>
<body>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <h1>Edit Subject</h1>
    <form:form method="POST" action="/OnlineJournal_war_exploded/update_subject">
        <table >
            <tr>
                <td></td>
                <td><form:hidden  path="id" /></td>
            </tr>
            <tr>
                <td>Title: </td>
                <td><form:input path="title"  /></td>
            </tr>
            <tr>
                <td> </td>
                <td><input type="submit" value="Edit" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
