package com.dev.service;

import java.util.ArrayList;

import com.dev.dao.DAO;
import com.dev.dto.DTO;

public class Service {
	private static Service service = new Service();
	public DAO dao = DAO.getInstance();
	private Service() {}
	
	public static Service getInstance()
	{
		return service;
	}

	public void subjectEnrollment(String profId, DTO subject) {
		dao.subjectEnrollment(profId ,subject);
	}

	public boolean search(String subjectId) {
		return dao.search(subjectId);
	}

	public void studentSubjectEnrollment(String id, String subjectId, DTO subject) {
		dao.studentSubjectEnrollment(id, subjectId, subject);
	}
}
