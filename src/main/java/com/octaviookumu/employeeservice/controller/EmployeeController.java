package com.octaviookumu.employeeservice.controller;

import com.octaviookumu.employeeservice.model.EmployeeCreateRequest;
import com.octaviookumu.employeeservice.model.EmployeeResponse;
import com.octaviookumu.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // abstract the Entity layer from the controller by using a Dto
    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeCreateRequest employeeCreateRequest) {
        return employeeService.createEmployee(employeeCreateRequest);
    }

    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{employeeNumber}")
    public EmployeeResponse getEmployee(@PathVariable(value = "employeeNumber") Integer employeeNumber) {
        return employeeService.getEmployee(employeeNumber);
    }

    @DeleteMapping("{employeeNumber}")
    public String deleteEmployee(@PathVariable(value = "employeeNumber") Integer employeeNumber) {
        return employeeService.deleteEmployee(employeeNumber);
    }

}
