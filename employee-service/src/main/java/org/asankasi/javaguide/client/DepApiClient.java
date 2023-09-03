package org.asankasi.javaguide.client;

import org.asankasi.javaguide.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepApiClient {

    @GetMapping("api/departments/{dep-code}")
    DepartmentDTO getDepartmentByCode(@PathVariable("dep-code") String departmentCode);
}
