<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>



<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザー管理ページ</title>
</head>
<body>
	<h1>ユーザー管理ページ</h1>
	<table>
		<tr>
			<th>ユーザーID</th>
			<th>メールアドレス</th>
			<th>パスワード</th>
			<th>権限</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td>${user.role}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
