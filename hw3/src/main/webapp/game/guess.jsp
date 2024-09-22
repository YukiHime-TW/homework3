<%@page import="com.systex.hw3.game.service.GuessGame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guess Game</title>
<link href="<%= request.getContextPath() %>/style/myStyle.css" rel="stylesheet" />
</head>
<body>
	<h2>Guess Game</h2>
    <p>Guess a number between 1 ~ 10</p>
    <form action="gameController.do" method="post">
        <input type="text" name="guess" />
        <input type="submit" value="Guess" />
    </form>
    
    <% 
        GuessGame game = (GuessGame) session.getAttribute("game"); 
        if (game != null) {
    %>
        <h2>Remains: <%= game.getRemains() %></h2>
    <% 
        } else {
    %>
        <h2>The game has not started yet. Please start a new game.</h2>
    <% 
        }
        
        // 顯示錯誤訊息
        String errorMsg = (String) request.getAttribute("errorMsg");
        if (errorMsg != null) {
    %>
        <p style="color:red;"><%= errorMsg %></p>
    <% 
        }
    %>
</body>
</html>
