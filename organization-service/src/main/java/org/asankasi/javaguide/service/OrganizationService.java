package org.asankasi.javaguide.service;

import org.asankasi.javaguide.dto.OrganizationDTO;
import org.asankasi.javaguide.entity.Organization;

public interface OrganizationService {
    OrganizationDTO saveOrganization(OrganizationDTO dto);

    OrganizationDTO getOrganizationByCode(String orgCode);
}
