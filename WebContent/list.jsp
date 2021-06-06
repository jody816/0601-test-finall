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
	String sql = "select subject.id, subject.name from enroll, subject where enroll.subject = subject.id and enroll.student = '1234';";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>학생 : 수강신청한 과목 리스트</h3>
	<%
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, pwd);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
	%>
	<table border="1">
		<tr><th>과목번호</th><th>과목명</th></tr>
	<%
		while(rs.next()){
	%>
	<tr>
		<td><%=rs.getString("subject.id")%></td>
		<td><%=rs.getString("subject.name")%></td>
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
	<a href="smenu.jsp">Menu</a>
</body>
</html>