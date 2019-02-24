package com.projects.example.customer.service.impl;

import com.projects.example.customer.dao.DepartmentRepository;
import com.projects.example.customer.dao.EmployeeRepository;
import com.projects.example.customer.model.Employee;
import com.projects.example.customer.model.EmployeeDTO;
import com.projects.example.customer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;



    @Override
    public List<Employee> getAllEmployeesByDept(String deptName) {

        return employeeRepository.findEmployeeByDepartmentDeptName(deptName);

    }

    @Override
    public void postNewEmployee (List<EmployeeDTO> employeeList) {
        employeeList.forEach(employeeDTO -> employeeRepository.postEmployee(employeeDTO));
    }

   /* @Override
    public void updateEmployee(List<EmployeeDTO> employeeDTOList) {

    }*/



}
