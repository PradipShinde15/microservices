package com.pradip.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradip.departmentservice.dto.DepartmentDto;
import com.pradip.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
	
	private DepartmentService departmentService;
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto newDepartment = departmentService.saveDepartment(departmentDto);
		
		return new ResponseEntity<DepartmentDto>(newDepartment,HttpStatus.CREATED);
		
	}
	
	
	//build get Department rest api
	@GetMapping("/{code}")
	public ResponseEntity<DepartmentDto> getDepartmentbyCode(@PathVariable String code){
		
			DepartmentDto department = departmentService.getDepartmentByCode(code);
			return ResponseEntity.status(HttpStatus.OK).body(department);
		
	}

}
