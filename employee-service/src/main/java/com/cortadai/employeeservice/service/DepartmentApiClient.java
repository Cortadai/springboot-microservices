package com.cortadai.employeeservice.service;

import com.cortadai.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentApiClient {

    @GetMapping("api/department/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable("code") String code);

}
