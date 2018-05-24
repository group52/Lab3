
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Journal for ${student.title}</h2>
<table border = "2" >
    <tr>
        <th>Name</th>
        <c:forEach var = "date" items = "${dates}">
            <th>${date}</th>
        </c:forEach>
    </tr>
    <c:forEach items="${journal}" var="subject">
        <tr>
            <td>${subject.key}</td>
            <c:forEach var = "mark" items = "${subject.value}">
                <td>${mark.value}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>
