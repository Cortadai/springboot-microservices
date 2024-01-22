package com.cortadai.organizationservice.service;

import com.cortadai.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto findByCode(String code);

}
