package com.projects.example.customer.controller;

import com.projects.example.customer.model.Employee;
import com.projects.example.customer.model.EmployeeDTO;
import com.projects.example.customer.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class EmployeeController {

    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployeesByDept (@RequestParam("dept_name") String deptName) {

        return employeeService.getAllEmployeesByDept(deptName);
    }

    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Employee> postNewEmployee (@RequestBody List<EmployeeDTO> employeeList) {

        return employeeService.postNewEmployee(employeeList);
    }
}
