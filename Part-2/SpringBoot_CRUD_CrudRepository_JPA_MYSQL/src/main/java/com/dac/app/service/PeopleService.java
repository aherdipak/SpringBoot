package com.dac.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dac.app.bean.People;
import com.dac.app.dao.PeopleDao;

@Service
public class PeopleService {

	@Autowired
	private PeopleDao peopleDao;
	
	public People addPerson(People people) {
		return peopleDao.save(people);
	}

	public List<People> addPeople(List<People> personList) {
		return (List<People>) peopleDao.saveAll(personList);
	}

}
