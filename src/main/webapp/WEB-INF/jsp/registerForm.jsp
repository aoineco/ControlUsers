<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>
 
<body>
  <h1>アカウント登録フォーム</h1>

	<form action="/Web/RegisterUser" method="post">
	 <table>
	      <tr>
	        <td>Email:</td>
	        <td><input type="email" name="email" required></td>
	      </tr>
	      <tr>
	        <td>Password:</td>
	        <td><input type="password" name="password" required></td>
	      </tr>
	      <tr>
	        <td>Name:</td>
	        <td><input type="text" name="name" required></td>
	      </tr>
	      <tr>
	        <td colspan="2"><input type="submit" value="登録"></td>
	      </tr>
	    </table>
	</form>
 
</body>
</html>