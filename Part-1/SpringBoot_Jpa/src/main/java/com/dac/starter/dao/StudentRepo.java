package com.dac.starter.dao;

import org.springframework.data.repository.CrudRepository;

import com.dac.starter.model.Student;

													//Table ,PK
public interface StudentRepo extends CrudRepository<Student, Integer>{

	
}
