package com.octaviookumu.employeeservice.controller;

import com.octaviookumu.employeeservice.model.EmployeeCreateRequest;
import com.octaviookumu.employeeservice.model.EmployeeResponse;
import com.octaviookumu.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // abstract the Entity layer from the controller by using a Dto
    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeCreateRequest employeeCreateRequest){
        return employeeService.createEmployee(employeeCreateRequest);
    }

}
