<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
  	%>
  	<p style="color: red;"><%= errorMessage %></p>
  <%
    }
  %>
  <form action="LoginServlet" method="post">
    <div>
      <label for="email">Email:</label>
      <input type="text" id="email" name="email">
    </div>
    <div>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password">
    </div>
    <input type="submit" value="Login">
  </form>
  	<br>
  	<p>アカウントをお持ちでない方</p>
	<a href="/Web/RegisterUser">会員登録</a>

</body>
</html>
