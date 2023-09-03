package org.asankasi.javaguide.controller;

import lombok.AllArgsConstructor;
import org.asankasi.javaguide.dto.OrganizationDTO;
import org.asankasi.javaguide.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationService orgService;

    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationDTO dto) {
        var organization = orgService.saveOrganization(dto);
        return new ResponseEntity<>(organization, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDTO> getOrganizationByCode(@PathVariable("code") String organizationCode) {
        var organization = orgService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organization);
    }
}
