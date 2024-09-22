<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%= request.getContextPath() %>/style/myStyle.css" rel="stylesheet" />
</head>
<body>
    <h2>樂透開獎結果</h2>
<table border="1" style="margin:auto; text-align:left;">
    <thead>
        <tr>
            <th>組數</th>
            <th>號碼</th>
    </thead>
    <tbody>
    	<%
    	String[] result = (String[]) request.getAttribute("result");
    	for(int i = 0; i < result.length; i++) {%>
	        <tr>
	        	<td>第<%= i+1 %>組號碼</td>
	            <td>
                    <%= result[i] %>
	            </td>
	        </tr>
        <% } %>
    </tbody>
</table>
<a href="<%= request.getContextPath() %>">Go Home</a>
</body>
</html>