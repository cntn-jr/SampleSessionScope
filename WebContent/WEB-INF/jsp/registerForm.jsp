<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録</title>
</head>
<body>
	<form action="/SampleSessionScope/Register" method="post">
		ログインID：<input type="text" name="id"><br>
		パスワード：<input type="password" name="password"><br>
		名前：<input type="text" name="name"><br>
		<input type="submit" value="確認"><br>
	</form>
</body>
</html>