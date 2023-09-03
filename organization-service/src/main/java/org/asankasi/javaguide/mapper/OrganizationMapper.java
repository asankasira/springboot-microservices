package org.asankasi.javaguide.mapper;

import org.asankasi.javaguide.dto.OrganizationDTO;
import org.asankasi.javaguide.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {

    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    OrganizationDTO mapToOrganizationDto(Organization org);

    Organization mapToOrganizationEntity(OrganizationDTO dto);
}
