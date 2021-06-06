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
	String sql = "select subject.id as 과목번호, subject.name as 과목명, subject.count as 최대인원, count(*) as 수강인원 from subject, enroll where subject.id = enroll.subject and subject.prof = '1' group by subject;";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>교수 : 등록한 과목 리스트</h3>
	<%
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, pwd);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
	%>
	<table border="1">
		<tr><th>과목번호</th><th>과목명</th><th>최대인원</th><th>수강인원</th></tr>
	<%
		while(rs.next()){
	%>
	<tr>
		<td onclick="location.href='pslist.jsp'"><%=rs.getString("과목번호")%></td>
		<td><%=rs.getString("과목명")%></td>
		<td><%=rs.getString("최대인원")%></td>
		<td><%=rs.getString("수강인원")%></td>
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