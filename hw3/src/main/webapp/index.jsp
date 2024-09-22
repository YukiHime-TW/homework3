<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link href="<%= request.getContextPath() %>/style/myStyle.css" rel="stylesheet"></link>
</head>
<body>
    <a href="lottery/main.jsp">Lottery</a><br/>
    <a href="${pageContext.request.contextPath}/gameController.do">guess game</a>
</body>
</html>