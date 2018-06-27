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
<a href = "loginChange?id=${entityParameter.entityId}"> Change Password </a>
<h2>Parameter Information</h2>
<form:form method = "POST" action = "saveParam" modelAttribute="entityParameter">
    <table>
        <tr>
            <td><form:label path = "parameterId">Parameter Id</form:label></td>
            <td><form:select path="parameterId" cssStyle="width: 150px;">
                <option value="${entityParameter.parameterId}">Parameter (default ${entityParameter.parameterId})</option>
                <c:forEach items="${parameters}" var="parameter">
                    <option value="${parameter.id}">${parameter.id} - ${parameter.title}</option>
                </c:forEach>
            </form:select><td>
        </tr>
        <tr>
            <td><form:label path = "entityId">Entity Id</form:label></td>
            <td><form:input path = "entityId" /></td>
        </tr>
        <tr>
            <td><form:label path = "stringValue">String Value</form:label></td>
            <td><form:input path = "stringValue" /></td>
        <tr>
            <td><form:label path = "intValue">Int Value</form:label></td>
            <td><form:input path = "intValue" /></td>
        </tr>
        <tr>
            <td><form:label path = "decimalValue">Decimal Value</form:label></td>
            <td><form:input path = "decimalValue" /></td>
        </tr>
        <tr>
            <td><form:label path = "idValue">Id Value</form:label></td>
            <td><form:input path = "idValue" /></td>
        </tr>
        <tr>
            <td><form:label path = "dateString">Date Value</form:label></td>
            <td><form:input path = "dateString" id="datepicker" value="${entityParameter.dateValue}"/></td>
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
    <tr><th>Parameter Id</th><th>String Value</th><th>Int Value</th><th>Decimal Value</th><th>Id Value</th><th>Date Value</th><th>Delete</th><th>Edit</th></tr>
    <c:forEach var = "entityParameter" items = "${list}">
        <tr>
            <td>${entityParameter.parameterId}</td>
            <td>${entityParameter.stringValue}</td>
            <td>${entityParameter.intValue}</td>
            <td>${entityParameter.decimalValue}</td>
            <td>${entityParameter.idValue}</td>
            <td>${entityParameter.dateValue}</td>
            <td><a href = "deleteParam?param=${entityParameter.parameterId}&id=${entityParameter.entityId}"> delete </a></td>
            <td><a href = "editParam?param=${entityParameter.parameterId}&id=${entityParameter.entityId}"> edit </a></td>
        </tr>
    </c:forEach>
</table>
<a href = "viewAll"> View all entities </a>
</body>
</html>
