<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({
                dateFormat: "yy-mm-dd"
            });
        } );
        var $datepicker = $('#datepicker');
        $datepicker.datepicker();
        $datepicker.datepicker('setDate', new Date());
    </script>

</head>

<body>
<h2>StudyLoad Information</h2>
<form:form method = "POST" action = "saveStudyLoad" modelAttribute="studyLoad">
    <table>
        <form:hidden path="id"/>
        <form:hidden path="parentId"/>
        <form:hidden path="entityType"/>
        <form:hidden path="title"/>
        <tr>
            <td><form:label path = "groupId">Group Id</form:label></td>
            <td><form:select path="groupId" cssStyle="width: 150px;">
                <option value="0">Groups </option>
                <c:forEach items="${listGroup}" var="group">
                    <option value="${group.id}">${group.id} - ${group.title}</option>
                </c:forEach>
            </form:select><td>
        </tr>
        <tr>
            <td><form:label path = "tutorId">Tutor Id</form:label></td>
            <td><form:select path="tutorId" cssStyle="width: 150px;">
                <option value="0">Tutors </option>
                <c:forEach items="${listTutor}" var="tutor">
                <option value="${tutor.id}">${tutor.id} - ${tutor.title}</option>
                </c:forEach>
            </form:select><td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>

<h2>Parameter List</h2>
<table border = "2" >
    <tr><th>Parameter Id</th><th>Id Value</th><th>Delete</th><th>Edit</th></tr>
    <c:forEach var = "entityParameter" items = "${list}">
        <tr>
            <td>${entityParameter.parameterId}</td>
            <td>${entityParameter.idValue}</td>
            <td><a href = "deleteParam?param=${entityParameter.parameterId}&id=${entityParameter.entityId}"> delete </a></td>
            <td><a href = "editParam?param=${entityParameter.parameterId}&id=${entityParameter.entityId}"> edit </a></td>
        </tr>
    </c:forEach>
</table>
<a href = "viewAll"> View all entities </a>
</body>
</html>
