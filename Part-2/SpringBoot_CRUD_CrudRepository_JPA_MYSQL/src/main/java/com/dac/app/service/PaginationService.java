package com.dac.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dac.app.bean.Employee;
import com.dac.app.dao.PaginationDao;

@Service
public class PaginationService {
	
	@Autowired
	private PaginationDao paginationDao;

	public List<Employee> addEmployee(List<Employee> employeeList) {
		return (List<Employee>)paginationDao.saveAll(employeeList);
	}

	public List<Employee> getPaginationDataByLastName(String lastName, PageRequest pageRequest) {
		return paginationDao.getPaginationDataByLastName(lastName, pageRequest);
	}

	public CompletableFuture<Employee> findByEmail(String string) {
		return paginationDao.findByEmail(string);
	}

	
	
}
