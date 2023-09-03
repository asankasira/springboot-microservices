package org.asankasi.javaguide.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.asankasi.javaguide.client.DepApiClient;
import org.asankasi.javaguide.client.OrgApiClient;
import org.asankasi.javaguide.dto.ApiResponseDTO;
import org.asankasi.javaguide.dto.DepartmentDTO;
import org.asankasi.javaguide.dto.EmployeeDTO;
import org.asankasi.javaguide.dto.OrganizationDTO;
import org.asankasi.javaguide.entity.Employee;
import org.asankasi.javaguide.exception.ResourceNotFoundException;
import org.asankasi.javaguide.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import static org.asankasi.javaguide.mapper.EmployeeMapper.INSTANCE;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
//    private final RestTemplate restTemplate;
//    private final WebClient webClient;
    private final DepApiClient depApiClient;
    private final OrgApiClient orgApiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO dto) {
        Employee emp = INSTANCE.mapToEmployeeEntity(dto);
        Employee savedEmp = repository.save(emp);
        return INSTANCE.mapToEmployeeDto(savedEmp);
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
//    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponseDTO getEmployeeById(Long employeeId) {
        log.info("Inside getEmployeeById method");

        Employee emp = repository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));
        EmployeeDTO empDto = INSTANCE.mapToEmployeeDto(emp);

//        ResponseEntity<DepartmentDTO> response = restTemplate.getForEntity("http://localhost:8080/api/departments/" + empDto.getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO = response.getBody();

        //synchronous communication with WebClient
//        DepartmentDTO departmentDTO = webClient.get()
////                .uri("http://localhost:8080/api/departments/{dep-code}", empDto.getDepartmentCode())
//                .uri("http://localhost:8080/api/departments/" + empDto.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();

        DepartmentDTO departmentDTO = depApiClient.getDepartmentByCode(empDto.getDepartmentCode());
        OrganizationDTO organizationDTO = orgApiClient.getOrganizationByCode(empDto.getOrganizationCode());

//        OrganizationDTO organizationDTO = webClient.get()
////                .uri("http://localhost:8083/api/organizations/{code}", empDto.getOrganizationCode())
//                .uri("http://localhost:8083/api/organizations/" + empDto.getOrganizationCode())
//                .retrieve()
//                .bodyToMono(OrganizationDTO.class)
//                .block();

        var apiResponse = new ApiResponseDTO();
        apiResponse.setEmployeeDTO(empDto);
        apiResponse.setDepartmentDTO(departmentDTO);
        apiResponse.setOrganizationDTO(organizationDTO);

        return apiResponse;
    }

    public ApiResponseDTO getDefaultDepartment(Long employeeId, Throwable ex) {
        log.info("Inside getDefaultDepartment method");

        Employee emp = repository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));
        EmployeeDTO empDto = INSTANCE.mapToEmployeeDto(emp);

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentName("R&D Department");
        departmentDTO.setDepartmentCode("RD001");
        departmentDTO.setDepartmentDescription("Research and Dev Department");

        var apiResponse = new ApiResponseDTO();
        apiResponse.setEmployeeDTO(empDto);
        apiResponse.setDepartmentDTO(departmentDTO);

        return apiResponse;
    }
}
