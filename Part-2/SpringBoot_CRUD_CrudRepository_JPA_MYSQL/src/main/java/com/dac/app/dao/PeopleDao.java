package com.dac.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.dac.app.bean.People;

public interface PeopleDao extends CrudRepository<People, Integer>{

}
