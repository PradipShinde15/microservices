package com.pradip.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pradip.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	Department findByDepartmentCode(String code);
}
