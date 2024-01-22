package com.cortadai.organizationservice.service.impl;

import com.cortadai.organizationservice.dto.OrganizationDto;
import com.cortadai.organizationservice.entity.Organization;
import com.cortadai.organizationservice.mapper.OrganizationMapper;
import com.cortadai.organizationservice.repository.OrganizationRepository;
import com.cortadai.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository repository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToEntity(organizationDto);
        Organization savedOrganization = repository.save(organization);
        return OrganizationMapper.mapToDto(savedOrganization);
    }

    @Override
    public OrganizationDto findByCode(String code) {
        Organization organization = repository.findByOrganizationCode(code);
        return OrganizationMapper.mapToDto(organization);
    }

}
