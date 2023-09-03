package org.asankasi.javaguide.client;

import org.asankasi.javaguide.dto.OrganizationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrgApiClient {

    @GetMapping("api/organizations/{code}")
    OrganizationDTO getOrganizationByCode(@PathVariable("code") String organizationCode);
}
