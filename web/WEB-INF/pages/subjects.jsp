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

    </body>
</html>
