package com.dac.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.dac.app.bean.Student;

public interface QueryAnnotationDao extends JpaRepository<Student, Integer> {

	//@Query(value = "SELECT s FROM Student s WHERE s.firstName = ?1")
	@Query(value = "SELECT * FROM STUDENT FIRST_NAME = ?1",nativeQuery = true)
	List<Student> getStudentInfoByName(String firstName);

	//@Query(value = "SELECT s FROM Student s WHERE s.id = ?1 and s.firstName = ?2")
	@Query(value = "SELECT * FROM STUDENT  WHERE ID = ?1 AND FIRST_NAME = ?2",nativeQuery = true)
	Student getStudentInfoByIdAndFirstName(int id, String firstName);

}
