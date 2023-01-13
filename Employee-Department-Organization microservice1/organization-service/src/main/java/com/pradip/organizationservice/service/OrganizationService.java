package com.pradip.organizationservice.service;

import com.pradip.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
	
	OrganizationDto saveOrganization(OrganizationDto organizationDto);

	OrganizationDto getOrganizationByCode(String organizationCode);
}
