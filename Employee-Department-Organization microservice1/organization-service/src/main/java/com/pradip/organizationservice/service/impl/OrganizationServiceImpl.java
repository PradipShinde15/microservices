package com.pradip.organizationservice.service.impl;

import javax.websocket.server.ServerEndpoint;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.pradip.organizationservice.dto.OrganizationDto;
import com.pradip.organizationservice.entity.Organization;
import com.pradip.organizationservice.repository.OrganizationRepository;
import com.pradip.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
	
	private OrganizationRepository organizationRepository;
	
	private ModelMapper modelMapper;
	
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		
		Organization organization = modelMapper.map(organizationDto, Organization.class);
		
		Organization organization1 = organizationRepository.save(organization);
		
		return modelMapper.map(organization1,OrganizationDto.class);
	}


	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {
		Organization org = organizationRepository.findByOrganizationCode(organizationCode);
		return modelMapper.map(org, OrganizationDto.class);
	}

}
