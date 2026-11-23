package com.wipro.employee.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.employee.dto.request.Employee;
import com.wipro.employee.exception.EmployeeIdNotFoundException;
import com.wipro.employee.service.EmployeeService;
@RequestMapping("api/v1/employee")
@RestController

public class EmployeeController 
{

   private EmployeeService employeeService;
   public EmployeeController(@Autowired EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
   
   @PostMapping
   public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
   {
	   return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws EmployeeIdNotFoundException
   {
	   return new ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.OK);
   }
   
   @GetMapping
   public ResponseEntity<List<Employee>> getAllEmployee()
   {
	   return new ResponseEntity<List<Employee>>(employeeService.findAll(),HttpStatus.OK);
   }
   @GetMapping("/firstname/{firstName}")
   
   public ResponseEntity<Employee> findByFirstName(@PathVariable String firstname)
   {
	   return new ResponseEntity<Employee>(employeeService.findByFirstName(firstname),HttpStatus.OK);
   }
}
