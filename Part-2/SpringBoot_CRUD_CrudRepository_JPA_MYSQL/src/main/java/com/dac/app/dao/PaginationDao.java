package com.dac.app.dao;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.dac.app.bean.Employee;

public interface PaginationDao extends CrudRepository<Employee, Integer> {

	List<Employee> getPaginationDataByLastName(String lastName, Pageable pageable);

	@Async
	CompletableFuture<Employee> findByEmail(String email);

	@Query("SELECT e FROM Employee e WHERE e.lastName=:lastname or e.firstName=:firstname")
	List<Employee> findByLastNameOrFirstName(@Param("lastname")String lastName, 
											@Param("firstname")String firstName);


}
