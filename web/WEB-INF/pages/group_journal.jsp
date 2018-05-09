
<%@ page contentType = "text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

        <table border = "2" >
            <tr><th>ID</th><th>Name</th><th>Group</th></tr>
            <c:forEach var = "student" items = "${list}">
            <tr>
                <td>${student.student_id}</td>
                <td>${student.student_name}</td>
                <td>${student.group_title}</td>
            </tr>
            </c:forEach>
        </table>

</body>
</html>
