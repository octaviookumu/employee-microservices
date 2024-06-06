package com.octaviookumu.employeeservice.service;

import com.octaviookumu.employeeservice.entity.Employee;
import com.octaviookumu.employeeservice.model.EmployeeCreateRequest;
import com.octaviookumu.employeeservice.model.EmployeeResponse;
import com.octaviookumu.employeeservice.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeResponse createEmployee(@Valid EmployeeCreateRequest employeeCreateRequest) {
        // copies all the fields and values from the employeeCreateRequest to the
        // employee
        Employee empReq = modelMapper.map(employeeCreateRequest, Employee.class);
        var savedEmployee = employeeRepository.save(empReq); // returns an employee

        // convert savedEmployee into EmployeeResponse
        return modelMapper.map(savedEmployee, EmployeeResponse.class);
    }

    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, EmployeeResponse.class))
                .toList();
    }

    public EmployeeResponse getEmployee(Integer employeeNumber) {
        return employeeRepository.findById(employeeNumber)
                .map(e -> modelMapper.map(e, EmployeeResponse.class))
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public String deleteEmployee(Integer employeeNumber) {
        employeeRepository.findById(employeeNumber)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.deleteById(employeeNumber);
        return "Success";
    }
}
