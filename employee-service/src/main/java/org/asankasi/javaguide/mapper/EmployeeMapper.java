package org.asankasi.javaguide.mapper;

import org.asankasi.javaguide.dto.EmployeeDTO;
import org.asankasi.javaguide.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO mapToEmployeeDto(Employee employee);

    Employee mapToEmployeeEntity(EmployeeDTO dto);
}
