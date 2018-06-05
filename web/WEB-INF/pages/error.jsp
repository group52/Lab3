<%--
  Created by IntelliJ IDEA.
  User: White Eagle
  Date: 09.05.2018
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h3>Sorry, we have some problems...</h3>
<p>
    Root cause of problem is <% exception.getCause(); %>
</p>
<p>
    Details: <% exception.printStackTrace(response.getWriter()); %>
</p>
</body>
</html>
