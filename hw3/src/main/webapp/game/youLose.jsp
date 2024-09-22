<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>You Lose !!</title>
<link href="<%= request.getContextPath() %>/style/myStyle.css" rel="stylesheet"></link>
</head>
<body>
<h2 style="color:red;">You Lose !!</h2>
<a href="<%= request.getContextPath() %>">Go Home</a>
<% session.invalidate(); %>
</body>
</html>