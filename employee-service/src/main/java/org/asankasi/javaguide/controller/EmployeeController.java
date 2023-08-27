package org.asankasi.javaguide.controller;

import lombok.AllArgsConstructor;
import org.asankasi.javaguide.dto.EmployeeDTO;
import org.asankasi.javaguide.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO reqDto) {
        var employee = employeeService.saveEmployee(reqDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("{emp-id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("emp-id") Long employeeId) {
        var employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }
}
