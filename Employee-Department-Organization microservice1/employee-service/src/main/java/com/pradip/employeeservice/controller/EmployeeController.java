package com.pradip.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradip.employeeservice.dto.ApiResponseDto;
import com.pradip.employeeservice.dto.EmployeeDto;
import com.pradip.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private  EmployeeService employeeService;
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee( @RequestBody EmployeeDto employeeDto){
		EmployeeDto newEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(newEmployee,HttpStatus.CREATED);
		
	}
	//build get Employee rest api
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable long id){
		ApiResponseDto newEmployee = employeeService.getEmployeeById(id);
		return new ResponseEntity<ApiResponseDto>(newEmployee,HttpStatus.OK);
		
	}
	

	
	
	

}
