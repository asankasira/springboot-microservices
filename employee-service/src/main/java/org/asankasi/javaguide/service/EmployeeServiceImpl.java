package org.asankasi.javaguide.service;

import lombok.AllArgsConstructor;
import org.asankasi.javaguide.client.DepApiClient;
import org.asankasi.javaguide.dto.ApiResponseDTO;
import org.asankasi.javaguide.dto.DepartmentDTO;
import org.asankasi.javaguide.dto.EmployeeDTO;
import org.asankasi.javaguide.entity.Employee;
import org.asankasi.javaguide.exception.ResourceNotFoundException;
import org.asankasi.javaguide.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import static org.asankasi.javaguide.mapper.EmployeeMapper.INSTANCE;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
//    private final RestTemplate restTemplate;
//    private final WebClient webClient;
    private final DepApiClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO dto) {
        Employee emp = INSTANCE.mapToEmployeeEntity(dto);
        Employee savedEmp = repository.save(emp);
        return INSTANCE.mapToEmployeeDto(savedEmp);
    }

    @Override
    public ApiResponseDTO getEmployeeById(Long employeeId) {
        Employee emp = repository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));
        EmployeeDTO empDto = INSTANCE.mapToEmployeeDto(emp);

//        ResponseEntity<DepartmentDTO> response = restTemplate.getForEntity("http://localhost:8080/api/departments/" + empDto.getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO = response.getBody();

        //synchronous communication with WebClient
//        DepartmentDTO departmentDTO = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + empDto.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();
        DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(empDto.getDepartmentCode());

        var apiResponse = new ApiResponseDTO();
        apiResponse.setEmployeeDTO(empDto);
        apiResponse.setDepartmentDTO(departmentDTO);

        return apiResponse;
    }
}
