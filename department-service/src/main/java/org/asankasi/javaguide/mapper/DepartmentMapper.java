package org.asankasi.javaguide.mapper;

import org.asankasi.javaguide.dto.DepartmentDTO;
import org.asankasi.javaguide.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDTO mapToDepartmentDto(Department dep);

    Department mapToDepartmentEntity(DepartmentDTO dto);
}
