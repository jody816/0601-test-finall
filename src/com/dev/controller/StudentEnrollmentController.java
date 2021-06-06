package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dto.DTO;
import com.dev.service.Service;

public class StudentEnrollmentController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectId = (String)request.getSession().getAttribute("subjectId");
		String id = (String)request.getSession().getAttribute("id");
		
		DTO subject = new DTO();
		subject.setId(id);
		subject.setSubjectId(subjectId);
		
		Service service = Service.getInstance();
		service.studentSubjectEnrollment(id, subjectId, subject);
		
		request.setAttribute("id", id);
		request.setAttribute("subjectId", subjectId);
		HttpUtil.forward(request, response, "smenu.jsp");
	}
}
