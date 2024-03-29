package com.cortadai.employeeservice.controller;

import com.cortadai.employeeservice.dto.EmployeeDto;
import com.cortadai.employeeservice.dto.ResponseDto;
import com.cortadai.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Service - EmployeeController",
        description = "EmployeeController exposes REST APIs for Employee Service"
)
@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;

    @Operation(
            summary = "Save Employee REST API",
            description = "Save Employee REST API is used to save employee object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto dto){
        return new ResponseEntity<>(service.saveEmployee(dto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee REST API is used to get employee object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
    }

}
