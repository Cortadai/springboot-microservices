package com.cortadai.employeeservice.service;

import com.cortadai.employeeservice.dto.EmployeeDto;
import com.cortadai.employeeservice.dto.ResponseDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto dto);
    ResponseDto getEmployeeById(Long id);
}
