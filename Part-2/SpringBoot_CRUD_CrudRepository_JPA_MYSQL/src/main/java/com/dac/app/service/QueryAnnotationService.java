package com.dac.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dac.app.bean.Student;
import com.dac.app.dao.QueryAnnotationDao;

@Service
public class QueryAnnotationService {

	@Autowired
	private QueryAnnotationDao queryAnnotationDao;
	
	public List<Student> addStudent(List<Student> studentList) {
		return (List<Student>) queryAnnotationDao.saveAll(studentList);
	}

	public List<Student> getStudentInfoByName(String firstName) {
		return queryAnnotationDao.getStudentInfoByName(firstName);
	}

	public Student getStudentInfoByIdAndFirstName(int id, String firstName) {
		return queryAnnotationDao.getStudentInfoByIdAndFirstName(id, firstName);
	}

}
