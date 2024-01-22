package com.cortadai.departmentservice.service.impl;

import com.cortadai.departmentservice.dto.DepartmentDto;
import com.cortadai.departmentservice.entity.Department;
import com.cortadai.departmentservice.repository.DepartmentRepository;
import com.cortadai.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository repository;
    private ModelMapper mapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = mapToEntity(departmentDto);
        Department savedDepartment = repository.save(department);
        return mapToDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = repository.findByDepartmentCode(code);
        return mapToDto(department);
    }

    private DepartmentDto mapToDto(Department department){
        return mapper.map(department, DepartmentDto.class);
    }

    private Department mapToEntity(DepartmentDto dto){
        return mapper.map(dto, Department.class);
    }

}
