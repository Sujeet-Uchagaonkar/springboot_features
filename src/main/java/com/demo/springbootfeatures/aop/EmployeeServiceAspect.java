package com.demo.springbootfeatures.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.demo.springbootfeatures.domain.Employee;

//This is aspect class
@Aspect
@Component
public class EmployeeServiceAspect {
	
	// AOP : Aspect based programming , application can be logically divided using cross cutting concerns. e.g. Spring AOP, AspectJ
	// Aspect : class with advice and pointcut definition
	// Pointcut : is an expression which decide where to execute an advice
	// Advice : an action taken before/after/around the execution pointcut
	// Join point : point of application execution where we can apply aspect
	// Target object : on which aspect is applied (In this case : EmployeeService.java)
	// Proxy: It is an object that is created after applying advice to a target object is called proxy. AOP implements the JDK dynamic proxy
	
	
	
	// pointcut (the expression language parameter)
	// join point will be "before execution of all methods" in EmployeeService class  
	@Before(value="execution(* com.demo.springbootfeatures.services.EmployeeService.*(..)) and args(id,empName)")
	public void beforeCreatingSampleEmployee(JoinPoint joinPoint, Integer id, String empName){
		//below sysout statements will be advices
		System.out.println("Before creating employee, with method : "+joinPoint.getSignature()); // method name
		System.out.println("Before creating employee, with kind/type : "+joinPoint.getKind()); //method-execution
		System.out.println("Before creating employee, with ags : "+id+ "/"+empName); //method arguments
	}
	
	@After(value="execution(* com.demo.springbootfeatures.services.EmployeeService.getNullEmployee()) and args()")
	public void afterNullEmpCreation(JoinPoint joinPoint){
		System.out.println("Before creating null employee, with method : "+joinPoint.getSignature()); // method name
		System.out.println("Before creating null employee, with kind/type : "+joinPoint.getKind()); //method-execution
	}

	// point cut can be created separately and referred it directly (line number 52)
	@Pointcut(value="execution(* com.demo.springbootfeatures.services.EmployeeService.getNullEmployee())")
	public void getNullEmpPointcut(){
		
	}
	
	@AfterReturning(pointcut="getNullEmpPointcut()")
	public void beforeCreatingNullEmp(){
		System.out.println("After returning from null emp creation");
	}
	
	@AfterReturning(value="execution(* com.demo.springbootfeatures.services.EmployeeService.getSampleEmployee(..))",returning="employee")
	public void afterReturningSampleEmployee(JoinPoint joinPoint, Employee employee){
		System.out.println("After returning sample employee, with method : "+joinPoint.getSignature()); // method name
		System.out.println("Returning obj: "+employee);
	}
	
	@Around(value="execution(* com.demo.springbootfeatures.services.EmployeeService.getSayHelloEmp())")
	public void aroundGetSayHelloEmp(JoinPoint joinPoint){
		System.out.println("Around AOP of method say hello emp with method: "+joinPoint.getSignature());
	}
	
	
	@Pointcut(value="execution(* com.demo.springbootfeatures.services.EmployeeService.getInValidEmp(..))")
	public void invalidEmpMethodPointCut(){
	}
	
	@AfterThrowing(pointcut="invalidEmpMethodPointCut()", throwing="ex")
	public void afterInvalidEmpException(JoinPoint joinPoint,Exception ex){
		System.out.println("After throwing invalid emp exception with method: "+joinPoint.getSignature());
		System.out.println("After throwing invalid emp exception with exception msg : "+ex.getMessage());
	}
	
	
	@Pointcut(value="execution(* com.demo.springbootfeatures.services.EmployeeService.getEmployees())")
	public void getEmployeesPointcut(){
	}
	
	@Around(value="getEmployeesPointcut()")
	public void aroundGetEmployees(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Around getEmployees - Before");
		pjp.proceed();
		System.out.println("Around getEmployees - After");
	}
}
