package com.dac.app.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.dac.app.bean.People;

public interface JpaQueryDao extends Repository<People, Integer> {

	List<People> findByLastName(String lastName);
	List<People> findByFirstNameAndEmail(String firstName,String email);
	List<People> findByFirstName(String firstName);
	List<People> getPeopleInfoByFirstNameAndLastName(String firstName, String lastName);
}
