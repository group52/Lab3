
<%@ page contentType = "text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Group journal for ${group.title} (subject "${subject.title}", tutor ${tutor.title})</h2>
        <table border = "2" >
            <tr>
                <th>Name</th>
                <c:forEach var = "date" items = "${dates}">
                    <th>${date}</th>
                </c:forEach>
            </tr>
            <c:forEach items="${journal}" var="student">
                <tr>
                    <td>${student.key.title}</td>
                    <c:forEach var = "mark" items = "${student.value}">
                        <td>${mark.value}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
