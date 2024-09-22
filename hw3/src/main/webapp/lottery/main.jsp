<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lottery</title>
<link href="<%= request.getContextPath() %>/style/myStyle.css" rel="stylesheet"></link>
</head>
<body>
	<%-- Error Report --%>
	<% LinkedList<String> errors = (LinkedList<String>)request.getAttribute("errors"); %>
	<% if(errors != null) { %>
		<ul style="color:red; font-size:0.8em;">
			<table border="0" style="margin:auto; text-align:left;">			
				<% for(String error : errors) { %>
					<tr><td><li><%= error %></li></td></tr>
				<% } %>
			</table>
		</ul>
	<% } %>
	<form action="lotteryController.do" method="post">
		<table style="text-align:left; margin:auto;">
			<tbody>
				<tr>
					<td>
						組數
					</td>
					<td>
						<input type="text" name="groupCount" />
					</td>
				</tr>
                <tr>
                    <td>
                        要排除的數字
                    </td>
                    <td>
                        <input type="text" name="excludeNumber" />
                    </td>
                </tr>
				<tr>
					<td>
						
					</td>
					<td>
						<input type="submit" value="送出"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>