package com.dac.app.service;

import java.util.List;
import java.util.Optional;

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

	public Iterable<People> getPeopleByIds(List<Integer> ids) {
		return peopleDao.findAllById(ids);
	}

	public void deletePeopleByIds(List<Integer> ids) {
		for (Integer integer : ids) {
			if(peopleDao.existsById(integer)) {
				peopleDao.deleteById(integer);
			}
		}
	}

	public void updatePeopleEmailById(int id, String newEmail) {
		Optional<People> list = peopleDao.findById(id);
		list.ifPresent(peson -> {
			 if(peson.getId() == id) {
				 peson.setEmail(newEmail);
				 System.out.println("final --> "+peopleDao.save(peson));
			 }
		});
		
	}

}
