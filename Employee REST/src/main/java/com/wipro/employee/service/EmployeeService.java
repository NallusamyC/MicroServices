package com.wipro.employee.service;

import java.util.List;

import com.wipro.employee.dto.request.Employee;
//import com.wipro.employee.exception.EmployeeIdNotFoundException;

public interface EmployeeService
{
 Employee saveEmployee(Employee employee);
 Employee findById(int id) ;
 List<Employee> findAll();

}
