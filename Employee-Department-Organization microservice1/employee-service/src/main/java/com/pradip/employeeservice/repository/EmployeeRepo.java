package com.pradip.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pradip.employeeservice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	

}
