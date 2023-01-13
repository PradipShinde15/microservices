package com.pradip.departmentservice.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;import org.springframework.boot.autoconfigure.web.servlet.DefaultJerseyApplicationPath;
import org.springframework.stereotype.Service;

import com.pradip.departmentservice.dto.DepartmentDto;
import com.pradip.departmentservice.entity.Department;
import com.pradip.departmentservice.exception.ResourceNotFoundException;
import com.pradip.departmentservice.repository.DepartmentRepository;
import com.pradip.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
     private DepartmentRepository departmentRepository;
     private ModelMapper modelMapper;
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
	
		
	Department department = modelMapper.map(departmentDto,Department.class);
	
	Department newDepartment = departmentRepository.save(department);
	
		return modelMapper.map(newDepartment,DepartmentDto.class);
	}
	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		
	
			Department department = Optional.ofNullable(departmentRepository
					.findByDepartmentCode(code)).orElseThrow(()->new ResourceNotFoundException("Department", "code", code));
		
		
//		if(department.equals(null)) {
//			throw new ResourceNotFoundException("Department", "code "+code,0);
//		}else {
//			
		return modelMapper.map(department, DepartmentDto.class);
			
		//}
		
		
	}

}
