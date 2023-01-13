package com.pradip.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradip.organizationservice.dto.OrganizationDto;
import com.pradip.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {
	
	private OrganizationService organizationService;
	
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto ){
		
		OrganizationDto organization = organizationService.saveOrganization(organizationDto);
		
		return new ResponseEntity<OrganizationDto>(organization,HttpStatus.CREATED);
		
	}
	
	//Build get organization by code Rest api
	@GetMapping("/{code}")
	public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code){
		
		OrganizationDto organization = organizationService.getOrganizationByCode(code);
		
		return ResponseEntity.ok(organization);
		
	}
	
	
	
	
	
	
	
}
