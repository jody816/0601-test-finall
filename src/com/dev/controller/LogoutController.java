package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.controller.HttpUtil;

public class LogoutController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("id") != null) {
			session.invalidate();
			HttpUtil.forward(request, response, "/index.jsp");
		}
		else {
			session.invalidate();
			out.print("You are not login State");
		}
		out.close();
	}
}