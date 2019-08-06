package com.dac.app.dao;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import com.dac.app.bean.Employee;

public interface PaginationDao extends CrudRepository<Employee, Integer> {

	List<Employee> getPaginationDataByLastName(String lastName, Pageable pageable);

	@Async
	CompletableFuture<Employee> findByEmail(String email);


}
