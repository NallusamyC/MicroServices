package com.wipro.employee.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.employee.dto.request.Employee;
import com.wipro.employee.exception.EmployeeIdNotFoundException;
import com.wipro.employee.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired 
	private EmployeeRepository employeeRepository;
	/*public EmployeeServiceImpl(EmployeeRepository employeeRepository) 
	{
		super();
		this.employeeRepository=employeeRepository;
	}*/
	@Transactional
	@Override
	public Employee saveEmployee(Employee employee) 
	{
		return employeeRepository.save(employee);
	
	}
	@Override
	public Employee findById(int id) throws EmployeeIdNotFoundException
	{
		Optional<Employee> optionalContainer=employeeRepository.findById(id);
		
			if(optionalContainer.isPresent())
				return optionalContainer.get();
			else
				throw new EmployeeIdNotFoundException("employee not found");
		
	}
	
	@Override
	public List<Employee> findAll()
	{
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee findByFirstName(String firstName)
	{
		return employeeRepository.findByFirstName(firstName);
	}
	

}

