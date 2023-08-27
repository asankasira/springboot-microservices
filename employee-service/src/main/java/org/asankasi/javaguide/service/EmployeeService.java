package org.asankasi.javaguide.service;

import org.asankasi.javaguide.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO dto);

    EmployeeDTO getEmployeeById(Long employeeId);
}
