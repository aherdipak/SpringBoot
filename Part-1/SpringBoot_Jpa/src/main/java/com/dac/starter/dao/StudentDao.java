package com.dac.starter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dac.starter.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{

}
