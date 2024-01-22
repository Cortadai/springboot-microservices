package com.cortadai.organizationservice.controller;

import com.cortadai.organizationservice.dto.OrganizationDto;
import com.cortadai.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - OrganizationController",
        description = "OrganizationController exposes REST APIs for Organization Service"
)
@RestController
@RequestMapping("api/organization")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService service;

    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save organization object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto dto){
        return new ResponseEntity<>(service.saveOrganization(dto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization REST API is used to get organization object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String code){
        return new ResponseEntity<>(service.findByCode(code), HttpStatus.OK);
    }

}
