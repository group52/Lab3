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
<h2>Parameter Information</h2>
<form:form method = "POST" action = "saveMark" modelAttribute="entityParameter">
    <table>
        <tr>
            <form:hidden path="parameterId"/>
        </tr>
        <tr>
            <td><form:label path = "entityId">Student</form:label></td>
            <td><form:select path="entityId" cssStyle="width: 150px;">
                <option value="${entityParameter.entityId}">Students</option>
                <c:forEach items="${students}" var="student">
                <option value="${student.id}">${student.id} - ${student.title}</option>
                </c:forEach>
            </form:select><td>
        </tr>
        <tr>
            <form:hidden path="stringValue"/>
        <tr>
            <form:hidden path="intValue"/>
        </tr>
        <tr>
            <td><form:label path = "decimalValue">Mark</form:label></td>
            <td><form:input path = "decimalValue" value="${entityParameter.decimalValue}"/></td>
        </tr>
        <tr>
            <form:hidden path="idValue"/>
        </tr>
        <tr>
            <td><form:label path = "dateString">Date</form:label></td>
            <td><form:input path = "dateString" id="datepicker" value="${entityParameter.dateValue}"/></td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>


<h2>Group journal for ${group.title} (subject "${subject.title}", tutor ${tutor.title})</h2>
        <table border = "2" >
            <tr>
                <th>Name</th>
                <c:forEach var = "date" items = "${dates}">
                    <th>${date}</th>
                </c:forEach>
                <th>Summa</th>
            </tr>
            <c:forEach items="${journal}" var="student">
                <tr>
                    <td>${student.key.title}</td>
                    <c:set var="markTotal" value="${0.0}" />
                    <c:forEach var = "mark" items = "${student.value}">
                        <td>${mark.value}</td>
                        <c:set var="markTotal" value="${markTotal + mark.value}" />
                    </c:forEach>
                    <td>${markTotal}</td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
