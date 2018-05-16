
<%@ page contentType = "text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

        <table border = "2" >
            <tr><th>ID</th><th>Name</th><th>Parent_id</th></tr>
            <c:forEach var = "student" items = "${list}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.parentId}</td>
            </tr>
            </c:forEach>
        </table>

</body>
</html>
