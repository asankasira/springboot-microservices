package org.asankasi.javaguide.service;

import lombok.AllArgsConstructor;
import org.asankasi.javaguide.dto.OrganizationDTO;
import org.asankasi.javaguide.entity.Organization;
import org.asankasi.javaguide.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import static org.asankasi.javaguide.mapper.OrganizationMapper.INSTANCE;


@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository orgRepository;
    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO dto) {
        Organization org = INSTANCE.mapToOrganizationEntity(dto);
        Organization savedOrg = orgRepository.save(org);
        return INSTANCE.mapToOrganizationDto(savedOrg);
    }

    @Override
    public OrganizationDTO getOrganizationByCode(String orgCode) {
        Organization org = orgRepository.findByOrganizationCode(orgCode);
        return INSTANCE.mapToOrganizationDto(org);
    }
}
