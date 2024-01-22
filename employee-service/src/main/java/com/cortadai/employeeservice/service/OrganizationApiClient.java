package com.cortadai.employeeservice.service;

import com.cortadai.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationApiClient {

    @GetMapping("api/organization/{code}")
    OrganizationDto getOrganizationByCode(@PathVariable("code") String code);

}