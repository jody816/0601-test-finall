<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>접속 중인 아이디<%=session.getAttribute("id") %></h1>
	<h3>Subject</h3>
	<form action="search.do" method="post">
		ID : <input type="text" name="subjectId" />
		<input type="submit" value="Search" />
	</form>
	<% 
		String result = (String)request.getAttribute("msg");
		if(result != null && result.equals("true")){
	%>
	<%
		if(session.getAttribute("subjectId").equals("1001")){
			out.print("web");}
		else if(session.getAttribute("subjectId").equals("1002")){
			out.print("program");}
		else if(session.getAttribute("subjectId").equals("1003")){
			out.print("ai");}
		else if(session.getAttribute("subjectId").equals("1004")){
			out.print("data");}
		else if(session.getAttribute("subjectId").equals("1005")){
			out.print("linux");}
		else if(session.getAttribute("subjectId").equals("1006")){
			out.print("python");}
		else if(session.getAttribute("subjectId").equals("1007")){
			out.print("c");}
	%>
	
	<form action="senroll.do" method="post">
		<input type="submit" value="Enrollment" />
		<input type="hidden" name="subjectId" value="subjectId" />
		<input type="hidden" name="id" value="id" />
	</form>
	<%} else if(result != null && result.equals("false")){
		out.print("No receiver ID");
	}
	%>
	<p>
	<a href="smenu.jsp">Menu</a>
</body>
</html>