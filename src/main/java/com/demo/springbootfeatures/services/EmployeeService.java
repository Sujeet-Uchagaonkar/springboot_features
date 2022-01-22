package com.demo.springbootfeatures.services;

import org.springframework.stereotype.Service;

import com.demo.springbootfeatures.domain.Employee;
import com.demo.springbootfeatures.exceptions.InvalidEmployee;

@Service
public class EmployeeService {

	public Employee getSampleEmployee(Integer id, String empName) {
		System.out.println("In Method: Creating an employee");
		return new Employee(id, empName);
	}
	
	public Employee getNullEmployee() {
		System.out.println("In Method: Creating null employee");
		return new Employee();
	}

	public String getSayHelloEmp() {
		System.out.println("In Method: Creating sayHello response");
		return "Hello All!!!";
	}

	public String getInValidEmp() throws InvalidEmployee {
		//String empValid = "Valid";
		//try {
			throw new InvalidEmployee("This is Invalid Employee!!");
		/*} catch (Exception e) {
			System.out.println("Invalid Emp Exception thrown!!");
			empValid = "Invalid";
		}*/
		
		//return empValid;
	}

	public String getEmployees() {
	
		return "This is Employee Service AOP demo.. use /sample, /null, /sayhello, /invalid etc. endpoints to explore...";
	}
}
