package org.asankasi.javaguide.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
