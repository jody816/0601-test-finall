package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Controller>();
		list.put("/plogin.do", new PLoginController());
		list.put("/slogin.do", new SLoginController());
		list.put("/penroll.do", new ProfessorEnrollmentController());
		list.put("/penrollList.do", new ProfessorEnrollmentListController());
		list.put("/pstudentList.do", new ProfessorStudentListController());
		list.put("/search.do", new SubjectSearchController());
		list.put("/senroll.do", new StudentEnrollmentController());
		list.put("/slogout.do", new LogoutController());
		list.put("/logout.do", new PLogoutController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextP = req.getContextPath();
		String url = req.getRequestURI();
		String path = url.substring(contextP.length());
		Controller subController = list.get(path);
		subController.execute(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
