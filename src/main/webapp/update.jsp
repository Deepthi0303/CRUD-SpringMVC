<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update">
<input type="text" name="name" placeholder="Enter the Name">
<br>
<input type="email" name="email" readonly="readonly" placeholder="Enter the Mail" value=<%= request.getParameter("email")%>>
<br>
<input type="password" name="password" placeholder="Enter the password">
<br>
<button>Submit</button>
<button>Cancel</button>
</form>
</body>
</html>