<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <table>
    <thead>
      <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>password</th>
      </tr>
    </thead>
    <tbody>
      <%
      try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/satya", "root", "Satya@22551A4230");
        String sql = "select * from students";
        PreparedStatement pmst = conn.prepareStatement(sql);
        ResultSet rs = pmst.executeQuery();
      
      while (rs.next()) {
      %>
      <tr>
        <td><%=rs.getInt("id")%></td>
        <td><%=rs.getString("name")%></td>
        <td><%=rs.getString("email")%></td>
        <td><%=rs.getString("password")%></td>
      </tr>
      <%
      }
      }catch(Exception e){
        e.printStackTrace();
      }
      %>

    </tbody>
  </table>

</body>
</html>