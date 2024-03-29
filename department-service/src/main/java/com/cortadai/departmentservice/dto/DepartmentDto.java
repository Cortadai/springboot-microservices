package com.cortadai.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "DepartmentDto Model"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;
    @Schema(
            description = "Department Name"
    )
    private String departmentName;
    @Schema(
            description = "Department Description"
    )
    private String departmentDesc;
    @Schema(
            description = "Department Code"
    )
    private String departmentCode;
}
