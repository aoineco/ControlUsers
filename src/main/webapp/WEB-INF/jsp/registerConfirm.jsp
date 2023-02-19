<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="model.User" %>
<%User registerUser = (User) session.getAttribute("registerUser");%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>
 
<body>
<p>下記のユーザーを登録します。</p>
 
<p>
email：<%= registerUser.getEmail()%><br>
password：<%= registerUser.getPassword()%><br>
password：<%= registerUser.getName()%><br>
</p>
<br>
<a href="/ControlUser/RegisterUser">戻る</a>
<a href="/ControlUser/RegisterUser?action=done">登録</a>
</body>
</html>