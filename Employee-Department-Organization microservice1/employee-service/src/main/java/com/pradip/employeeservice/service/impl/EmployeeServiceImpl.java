package com.pradip.employeeservice.service.impl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.pradip.employeeservice.dto.ApiResponseDto;
import com.pradip.employeeservice.dto.DepartmentDto;
import com.pradip.employeeservice.dto.EmployeeDto;
import com.pradip.employeeservice.dto.OrganizationDto;
import com.pradip.employeeservice.entity.Employee;
import com.pradip.employeeservice.exception.ResourceNotFoundException;
import com.pradip.employeeservice.repository.EmployeeRepo;
import com.pradip.employeeservice.service.ApiClient;
import com.pradip.employeeservice.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepo employeeRepo;
    
    private ModelMapper modelMapper;
    
  //  private RestTemplate restTemplate;
    
    private WebClient client;
    
    
  


// private ApiClient apiClient;
    
   private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
    
    
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto,Employee.class);
		Employee newEmployee = employeeRepo.save(employee);
		return modelMapper.map(newEmployee, EmployeeDto.class);
		
	}
   // @CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepatment")
	@Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepatment")
	@Override
	public ApiResponseDto getEmployeeById(long employeeId) {
		
		logger.info("inside getEmployeeById() method");
		
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee", "id", employeeId));
		
		EmployeeDto employeeDto=modelMapper.map(employee, EmployeeDto.class);
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:6161/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//		
//		DepartmentDto departmentDto=responseEntity.getBody();
//		
      //  DepartmentDto departmentDto = apiClient.getDepartmentbyCode(employee.getDepartmentCode());
		
		DepartmentDto departmentDto = client.get()
		.uri("http://localhost:6161/api/departments/"+employee.getDepartmentCode())
		.retrieve().bodyToMono(DepartmentDto.class).block();
		
		OrganizationDto organizationDto=client.get()
		.uri("http://localhost:6464/api/organizations/"+employee.getOrganizationCode())
		.retrieve()
		.bodyToMono(OrganizationDto.class)
		.block();
		
		ApiResponseDto apiResponseDto=new ApiResponseDto();
		
		apiResponseDto.setDepartment(departmentDto);
		
		apiResponseDto.setEmployee(employeeDto);
		
		apiResponseDto.setOrganization(organizationDto);
	
	return  apiResponseDto; //modelMapper.map(employee, EmployeeDto.class);
	}
    
    public ApiResponseDto getDefaultDepatment(long employeeId,Exception exception) {
    	
    	
    	logger.info("inside getDefaultDepatment() method");
    	
    	Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee", "id", employeeId));
		EmployeeDto employeeDto=modelMapper.map(employee, EmployeeDto.class);
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:6161/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//		
//		DepartmentDto departmentDto=responseEntity.getBody();
//		
      //  DepartmentDto departmentDto = apiClient.getDepartmentbyCode(employee.getDepartmentCode());
		
//		DepartmentDto departmentDto = client.get()
//		.uri("http://localhost:6161/api/departments/"+employee.getDepartmentCode())
//		.retrieve().bodyToMono(DepartmentDto.class).block();	
		DepartmentDto departmentDto=new DepartmentDto();
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research and devlopment department");
		departmentDto.setDepartmentName("R & D department");
		
		ApiResponseDto apiResponseDto=new ApiResponseDto();
		
		apiResponseDto.setDepartment(departmentDto);
		
		apiResponseDto.setEmployee(employeeDto);
	
	return  apiResponseDto;
	
    	
    }

}
