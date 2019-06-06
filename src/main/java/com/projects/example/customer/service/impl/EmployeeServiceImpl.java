package com.projects.example.customer.service.impl;

import com.projects.example.customer.dao.DepartmentRepository;
import com.projects.example.customer.dao.EmployeeRepository;
import com.projects.example.customer.model.Department;
import com.projects.example.customer.model.Employee;
import com.projects.example.customer.model.EmployeeDTO;
import com.projects.example.customer.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }



    @Override
    public List<Employee> getAllEmployeesByDept(String deptName) {

        return employeeRepository.findEmployeeByDepartmentDeptName(deptName);

    }

    @Override
    public List<Employee> postNewEmployee (List<EmployeeDTO> employeeList) {

        List<Employee> returnEmployees = new ArrayList<>();

        employeeList.forEach(employeeDTO -> {

            Department department = departmentRepository.findDepartmentByDeptName
                    (employeeDTO.getDepartment().getDepartmentName());

            Employee employee = new Employee();
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setDesignation(employeeDTO.getDesignation());
            employee.setDepartment(department);
            returnEmployees.add(employeeRepository.save(employee));

        });

        return returnEmployees;
    }

   /* @Override
    public void updateEmployee(List<EmployeeDTO> employeeDTOList) {

    }*/



}
