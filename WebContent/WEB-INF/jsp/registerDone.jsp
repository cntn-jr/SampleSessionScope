<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% 
	User registerUser = (User) session.getAttribute("registerUser");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録</title>
</head>
<body>
	<p>登録完了しました</p>
	<a href="/SampleSessionScope/Register">戻る</a>
</body>
</html>