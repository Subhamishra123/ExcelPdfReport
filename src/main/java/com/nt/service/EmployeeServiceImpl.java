package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo repository;
	
	@Override
	public Iterable<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
