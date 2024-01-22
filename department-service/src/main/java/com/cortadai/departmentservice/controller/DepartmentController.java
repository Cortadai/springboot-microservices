package com.cortadai.departmentservice.controller;

import com.cortadai.departmentservice.dto.DepartmentDto;
import com.cortadai.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - DepartmentController",
        description = "DepartmentController exposes REST APIs for Department Service"
)
@RestController
@RequestMapping("api/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService service;

    @Operation(
            summary = "Save Department REST API",
            description = "Save Department REST API is used to save department object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(service.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Department REST API",
            description = "Get Department REST API is used to get department object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String code){
        return new ResponseEntity<>(service.getDepartmentByCode(code), HttpStatus.OK);
    }

}
