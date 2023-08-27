package org.asankasi.javaguide.service;

import org.asankasi.javaguide.dto.ApiResponseDTO;
import org.asankasi.javaguide.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO dto);

    ApiResponseDTO getEmployeeById(Long employeeId);
}
