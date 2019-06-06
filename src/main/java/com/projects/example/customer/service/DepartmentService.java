package com.projects.example.customer.service;

import com.projects.example.customer.model.Department;
import com.projects.example.customer.model.DepartmentDTO;

import java.util.List;


public interface DepartmentService {

    Department getDepartmentByName(String deptName);

    List<Department> postDepartments(List<DepartmentDTO> departments);

    void updateDepartments(List<DepartmentDTO> departments);

}
