package com.dac.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dac.app.bean.People;
import com.dac.app.dao.JpaQueryDao;

@Service
public class JpaQueryConceptService {
	
	@Autowired
	private JpaQueryDao jpaQueryDao;

	public List<People> getPeopleByLastName(String lastName) {
		return jpaQueryDao.findByLastName(lastName);
	}

	public List<People> getPeopleInfoByFistNameAndEmail(String firstName, String email) {
		return jpaQueryDao.findByFirstNameAndEmail(firstName, email);
	}

	public List<People> getPeopleInfoByFirstName(String firstName) {
		return jpaQueryDao.findByFirstName(firstName);
	}

	public List<People> getPeopleInfoByFirstNameAndLastName(String firstName, String lastName) {
		return jpaQueryDao.getPeopleInfoByFirstNameAndLastName(firstName,lastName);
	}

}
