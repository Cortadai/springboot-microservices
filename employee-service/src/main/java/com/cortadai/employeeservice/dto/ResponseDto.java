package com.cortadai.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;
    private OrganizationDto organization;
}
