package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.Service;
import com.dev.dto.DTO;

public class ProfessorEnrollmentListController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String profId = (String)request.getSession().getAttribute("profId");
	
		request.setAttribute("profId", profId);
		HttpUtil.forward(request, response, "/result/penrollList.jsp");
	}
}
