package org.asankasi.javaguide.service;

import org.asankasi.javaguide.dto.DepartmentDTO;

public interface DepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO dto);

    DepartmentDTO getDepartmentByCode(String departmentCode);
}
