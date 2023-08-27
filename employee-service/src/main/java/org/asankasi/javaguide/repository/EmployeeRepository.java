package org.asankasi.javaguide.repository;

import org.asankasi.javaguide.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
