<%@page import="spring_mvc.dto.Student_credential"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<Student_credential> l=(List<Student_credential>)request.getAttribute("obj"); %>
<table border=1 cellpadding="10px">
<tr>
<th>Name</th><th>Email</th><th>Password</th><th>Update</th><th>Delete</th>
</tr>
<% for(Student_credential det:l){ %>
<tr>
  <td><%= det.getName() %></td>
  <td><%= det.getEmail() %></td>
  <td><%= det.getPassword() %></td>
  <td><a href="update.jsp?email=<%= det.getEmail()%>">Update</a></td>
  <td><a href="deleteupdate?email=<%= det.getEmail()%>">Delete</a></td>
</tr>
<% } %>

</table>
</body>
</html>