package com.pradip.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pradip.employeeservice.dto.DepartmentDto;



@FeignClient(name ="DEPARTMENT-SERVICE")
public interface ApiClient {
	
	@GetMapping("api/departments/{code}")
	DepartmentDto getDepartmentbyCode(@PathVariable String code);

}
