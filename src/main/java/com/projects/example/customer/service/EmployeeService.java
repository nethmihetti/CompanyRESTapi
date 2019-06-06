package com.projects.example.customer.service;

import com.projects.example.customer.model.Employee;
import com.projects.example.customer.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployeesByDept(String deptName);

    List<Employee> postNewEmployee (List<EmployeeDTO> employeeList);

    //void updateEmployee(List<EmployeeDTO> employeeDTOList);

}
