package org.asankasi.javaguide.controller;

import lombok.AllArgsConstructor;
import org.asankasi.javaguide.dto.DepartmentDTO;
import org.asankasi.javaguide.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO dto) {
        var department = departmentService.createDepartment(dto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("{dep-code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable("dep-code") String departmentCode) {
        var department = departmentService.getDepartmentByCode(departmentCode);
        return ResponseEntity.ok(department);
    }
}
