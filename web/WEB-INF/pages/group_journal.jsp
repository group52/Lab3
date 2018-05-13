
<%@ page contentType = "text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

        <table border = "2" >
            <tr><th>ID</th><th>Name</th><th>Group</th></tr>
            <c:forEach var = "entity" items = "${list}">
            <tr>
                <td>${entity.id}</td>
                <td>${entity.title}</td>
                <td>${entity.parentId}</td>
            </tr>
            </c:forEach>
        </table>

</body>
</html>
