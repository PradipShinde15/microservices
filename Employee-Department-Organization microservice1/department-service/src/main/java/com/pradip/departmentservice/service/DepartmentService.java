package com.pradip.departmentservice.service;

import com.pradip.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String code);
	
	

}
