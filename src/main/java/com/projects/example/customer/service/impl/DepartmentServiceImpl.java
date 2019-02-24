package com.projects.example.customer.service.impl;

import com.projects.example.customer.dao.DepartmentRepository;
import com.projects.example.customer.model.Department;
import com.projects.example.customer.model.DepartmentDTO;
import com.projects.example.customer.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department getDepartmentByName(String deptName) {
        return departmentRepository.findDepartmentByDeptName(deptName);
    }

    @Override
    public void postDepartments(List<DepartmentDTO> departments) {
        departments.forEach(departmentDTO -> departmentRepository.postDepartment(departmentDTO));
    }

    @Override
    public void updateDepartments(List<DepartmentDTO> departments) {
        departments.forEach(departmentDTO -> departmentRepository.updateDepartment(departmentDTO));
    }

}
