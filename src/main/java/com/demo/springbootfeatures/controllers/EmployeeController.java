package com.demo.springbootfeatures.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootfeatures.domain.Employee;
import com.demo.springbootfeatures.exceptions.InvalidEmployee;
import com.demo.springbootfeatures.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/sample")
	public Employee getSampleEmployee(@RequestParam(name="id") Integer id, @RequestParam(name="empName") String empName) {
		return employeeService.getSampleEmployee(id,empName);
	}
	
	@GetMapping(value = "/null")
	public Employee getNullEmployee() {
		return employeeService.getNullEmployee();
	}
	
	@GetMapping(value = "/sayhello")
	public String getSayHelloEmp() {
		return employeeService.getSayHelloEmp();
	}
	
	@GetMapping(value = "/invalid")
	public String getInValidEmp() throws InvalidEmployee {
		return employeeService.getInValidEmp();
	}
}
