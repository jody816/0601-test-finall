package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.Service;
import com.dev.dto.DTO;

public class ProfessorEnrollmentController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String profId = (String)request.getSession().getAttribute("profId");
		String subjectId = request.getParameter("subjectId");
		String subjectName = request.getParameter("subjectName");
		int subjectCount = Integer.parseInt(request.getParameter("subjectCount"));
		
		DTO subject = new DTO();
		subject.setProfId(profId);
		subject.setSubjectId(subjectId);
		subject.setSubjectName(subjectName);
		subject.setSubjectCount(subjectCount);
		
		//service
		Service service = Service.getInstance();
		service.subjectEnrollment(profId, subject);
		
		request.setAttribute("profId", profId);
		HttpUtil.forward(request, response, "pmenu.jsp");
	}
}
