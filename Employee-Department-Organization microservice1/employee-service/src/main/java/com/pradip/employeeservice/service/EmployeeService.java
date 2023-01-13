package com.pradip.employeeservice.service;

import com.pradip.employeeservice.dto.ApiResponseDto;
import com.pradip.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	ApiResponseDto getEmployeeById(long employeeId);
	
}
