package com.dac.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.dac.app.bean.Student;

public interface QueryAnnotationDao extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT s FROM Student s WHERE s.firstName = ?1")
	List<Student> getStudentInfoByName(String firstName);

	@Query(value = "SELECT s FROM Student s WHERE s.id = ?1 and s.firstName = ?2")
	Student getStudentInfoByIdAndFirstName(int id, String firstName);

}
