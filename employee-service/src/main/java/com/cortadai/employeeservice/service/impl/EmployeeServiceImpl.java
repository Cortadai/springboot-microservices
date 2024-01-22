package com.cortadai.employeeservice.service.impl;

import com.cortadai.employeeservice.dto.DepartmentDto;
import com.cortadai.employeeservice.dto.EmployeeDto;
import com.cortadai.employeeservice.dto.OrganizationDto;
import com.cortadai.employeeservice.dto.ResponseDto;
import com.cortadai.employeeservice.entity.Employee;
import com.cortadai.employeeservice.repository.EmployeeRepository;
import com.cortadai.employeeservice.service.DepartmentApiClient;
import com.cortadai.employeeservice.service.EmployeeService;
import com.cortadai.employeeservice.service.OrganizationApiClient;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository repository;
    private ModelMapper mapper;
//    private RestTemplate template;
//    private WebClient client;
    private DepartmentApiClient departmentApiClient;
    private OrganizationApiClient organizationApiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto dto) {
        Employee employee = mapToEntity(dto);
        Employee savedEmployee = repository.save(employee);
        return mapToDto(savedEmployee);
    }

    @Override
//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public ResponseDto getEmployeeById(Long id) {
        LOGGER.info("inside getEmployeeById() method");
        Employee employee = repository.findById(id).get();
//        ResponseEntity<DepartmentDto> responseEntity = template.getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();
//        DepartmentDto departmentDto = client.get()
//                .uri("http://localhost:8080/api/department/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
        DepartmentDto departmentDto = departmentApiClient.getDepartmentByCode(employee.getDepartmentCode());
        OrganizationDto organizationDto = organizationApiClient.getOrganizationByCode(employee.getOrganizationCode());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setEmployee(mapToDto(employee));
        responseDto.setDepartment(departmentDto);
        responseDto.setOrganization(organizationDto);
        return responseDto;
    }

    private ResponseDto getDefaultDepartment(Long id, Exception e) {
        LOGGER.info("inside getDefaultDepartment() method");
        Employee employee = repository.findById(id).get();
        DepartmentDto defaultDto = new DepartmentDto();
        defaultDto.setDepartmentName("R&D Department");
        defaultDto.setDepartmentDesc("Research and Development Department");
        defaultDto.setDepartmentCode("RD001");
        ResponseDto responseDto = new ResponseDto();
        responseDto.setEmployee(mapToDto(employee));
        responseDto.setDepartment(defaultDto);
        return responseDto;
    }

    private EmployeeDto mapToDto(Employee employee){
        return mapper.map(employee, EmployeeDto.class);
    }

    private Employee mapToEntity(EmployeeDto dto){
        return mapper.map(dto, Employee.class);
    }
}
