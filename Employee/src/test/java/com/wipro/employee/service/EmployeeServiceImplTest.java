package com.wipro.employee.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.wipro.employee.dto.request.Employee;
import com.wipro.employee.exception.EmployeeIdNotFoundException;
import com.wipro.employee.repository.EmployeeRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testSaveEmployee() {

        Employee employee = new Employee();
        employee.setId(101);
        employee.setFirstName("John");

        when(employeeRepository.save(employee))
                .thenReturn(employee);

        Employee savedEmployee =
                employeeService.saveEmployee(employee);

        assertNotNull(savedEmployee);
        assertEquals(101, savedEmployee.getId());
        assertEquals("John", savedEmployee.getFirstName());

        verify(employeeRepository, times(1))
                .save(employee);
    }

    @Test
    void testFindById_Success() throws EmployeeIdNotFoundException {

        Employee employee = new Employee();
        employee.setId(101);
        employee.setFirstName("John");

        when(employeeRepository.findById(101))
                .thenReturn(Optional.of(employee));

        Employee result =
                employeeService.findById(101);

        assertNotNull(result);
        assertEquals(101, result.getId());
        assertEquals("John", result.getFirstName());

        verify(employeeRepository, times(1))
                .findById(101);
    }

    @Test
    void testFindById_ThrowsException() {

        when(employeeRepository.findById(999))
                .thenReturn(Optional.empty());

        EmployeeIdNotFoundException exception =
                assertThrows(
                        EmployeeIdNotFoundException.class,
                        () -> employeeService.findById(999));

        assertEquals("employee not found",
                exception.getMessage());

        verify(employeeRepository, times(1))
                .findById(999);
    }

    @Test
    void testFindAll() {

        Employee emp1 = new Employee();
        emp1.setId(101);
        emp1.setFirstName("John");

        Employee emp2 = new Employee();
        emp2.setId(102);
        emp2.setFirstName("David");

        List<Employee> employeeList =
                Arrays.asList(emp1, emp2);

        when(employeeRepository.findAll())
                .thenReturn(employeeList);

        List<Employee> result =
                employeeService.findAll();

        assertEquals(2, result.size());
        assertEquals("John",
                result.get(0).getFirstName());
        assertEquals("David",
                result.get(1).getFirstName());

        verify(employeeRepository, times(1))
                .findAll();
    }
}
