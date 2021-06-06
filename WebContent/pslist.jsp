<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%!// 변수 선언
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String uid = "root";
	String pwd = "2307";
	String url = "jdbc:mysql://localhost:3306/enrollment";
	String sql = "select student.id, student.name from student, enroll where student.id = enroll.student and enroll.subject = '1001';";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>교수 : 과목의 수강생 리스트</h3>
	웹서비스개발기초  총 수강인원 : 2명
	<%
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, pwd);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
	%>
	<table border="1">
		<tr><th>id</th><th>이름</th></tr>
	<%
		while(rs.next()){
	%>
	<tr>
		<td><%=rs.getString("student.id")%></td>
		<td><%=rs.getString("student.name")%></td>
	</tr>
	<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		try {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		%>
		</table>
	<p>
	<a href="pmenu.jsp">Menu</a>
</body>
</html>