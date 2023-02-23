<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>データベーステーブルの表示</title>
</head>
<body>
    <table>
        <tr>
            <th>Email</th>
            <th>Password</th>
            <th>Name</th>
        </tr>
        <% 
            // データベースに接続する
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", ">SmH%,b]zj`0qnVp`=F<n");

            // SQLクエリを作成して、データを取得する
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // 取得したデータを表示する
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("</tr>");
            }

            // リソースを解放する
            rs.close();
            stmt.close();
            conn.close();
        %>
    </table>
</body>
</html>

