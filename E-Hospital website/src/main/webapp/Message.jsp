<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        out.println("<p>" + msg + "</p>");
    }
%>
</body>
</html>
