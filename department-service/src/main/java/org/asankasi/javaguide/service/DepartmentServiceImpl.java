package org.asankasi.javaguide.service;

import lombok.AllArgsConstructor;
import org.asankasi.javaguide.dto.DepartmentDTO;
import org.asankasi.javaguide.entity.Department;
import org.asankasi.javaguide.exception.ResourceNotFoundException;
import org.asankasi.javaguide.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import static org.asankasi.javaguide.mapper.DepartmentMapper.INSTANCE;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO dto) {
        Department department = INSTANCE.mapToDepartmentEntity(dto);
        Department savedDep = repository.save(department);
        return INSTANCE.mapToDepartmentDto(savedDep);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department = repository.findByDepartmentCode(departmentCode)
                                .orElseThrow(() -> new ResourceNotFoundException("Department", "DepCode", departmentCode));
        return INSTANCE.mapToDepartmentDto(department);
    }
}
