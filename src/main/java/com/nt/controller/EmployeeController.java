package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String getHome()
	{
		return "home";
	}
	@GetMapping("/report")
	public String showReport(@RequestParam("type")String type,
							Map<String, Object> map)
	{
		Iterable<Employee> employees = service.getAllEmployees();
		map.put("empList", employees);
		if(type.equalsIgnoreCase("pdf")) {
			return "pdfreport";
		}
	
		return "excelreport";
	}

}
