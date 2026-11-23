package com.wipro.employee.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.employee.dto.request.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
//Employee findsByFirstName(String firstName);

}
