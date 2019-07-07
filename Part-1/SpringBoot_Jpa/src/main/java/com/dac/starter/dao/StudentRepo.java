package com.dac.starter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dac.starter.model.Student;

													//Table ,PK
public interface StudentRepo extends CrudRepository<Student, Integer>{

	List<Student> findByStdTech(String tech);
	// protocol's
	// 1. method name should start findBy this is the option they give you
	// 2. method name should end with the name of the  property so StdTech is a property of student class.
	
	
	List<Student> findByStdIdGreaterThan(int stdId);
	
	// Normally when you work with JPA you will be using JPQL it is almost same as HQL and HQL is similar to SQL.
	@Query("from Student where stdTech=?1 order by stdName")
	List<Student> findByStdTechSorted(String tech);
}
