<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>YongIn LMS</h3>
	<p>
	<form action="plogin.do" method="post">
		ID : <input type="text" name="profId" /><br>
		Password : <input type="password" name="profPwd" /><br>
		<input type="radio" value="Professor" checked />Professor
		<input type="radio" value="Student" OnClick="window.location.href='slogin.jsp'" />Student<br>
		<p>
		<input type="submit" value="Login" />
	</form>
</body>
</html>