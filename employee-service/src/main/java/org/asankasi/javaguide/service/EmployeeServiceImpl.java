package org.asankasi.javaguide.service;

import lombok.AllArgsConstructor;
import org.asankasi.javaguide.dto.EmployeeDTO;
import org.asankasi.javaguide.entity.Employee;
import org.asankasi.javaguide.exception.ResourceNotFoundException;
import org.asankasi.javaguide.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import static org.asankasi.javaguide.mapper.EmployeeMapper.INSTANCE;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO dto) {
        Employee emp = INSTANCE.mapToEmployeeEntity(dto);
        Employee savedEmp = repository.save(emp);
        return INSTANCE.mapToEmployeeDto(savedEmp);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee emp = repository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));
        return INSTANCE.mapToEmployeeDto(emp);
    }
}
