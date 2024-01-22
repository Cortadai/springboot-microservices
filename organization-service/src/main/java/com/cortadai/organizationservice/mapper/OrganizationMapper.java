package com.cortadai.organizationservice.mapper;

import com.cortadai.organizationservice.dto.OrganizationDto;
import com.cortadai.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToDto(Organization organization){
        return new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDesc(),
                organization.getOrganizationCode(),
                organization.getCreationDate()
        );
    }

    public static Organization mapToEntity(OrganizationDto organizationDto){
        return new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDesc(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreationDate()
        );
    }

}
