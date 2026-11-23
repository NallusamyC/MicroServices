package com.wipro.employee.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.wipro.employee.dto.response.ErrorResponse;
import com.wipro.employee.exception.EmployeeIdNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
  @ExceptionHandler(EmployeeIdNotFoundException.class)
   public ResponseEntity<ErrorResponse> handleEmployeeIdNotFoundException(EmployeeIdNotFoundException ex)
   {
	   ErrorResponse errorResponse=new ErrorResponse();
	   errorResponse.setMessage(ex.toString());
	   errorResponse.setStatus(HttpStatus.NOT_FOUND);
	   return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
   }
	   
   
}

