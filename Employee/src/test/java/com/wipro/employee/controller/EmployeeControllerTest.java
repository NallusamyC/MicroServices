package com.wipro.employee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.ResponseEntity;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.employee.dto.request.Employee;
import com.wipro.employee.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	    @Mock
	    private EmployeeService employeeService;

	    @InjectMocks
	    private EmployeeController employeeController;

	    @Test
	    void testGetEmployeeById() throws Exception {

	        Employee employee = new Employee();
	        employee.setId(101);
	        employee.setFirstName("John");

	        when(employeeService.findById(101)).thenReturn(employee);

	        ResponseEntity<Employee> response =
	                employeeController.getEmployeeById(101);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(101, response.getBody().getId());
	        assertEquals("John", response.getBody().getFirstName());
	    }
	}
    
