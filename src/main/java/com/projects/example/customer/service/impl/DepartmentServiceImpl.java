package com.projects.example.customer.service.impl;

import com.projects.example.customer.dao.DepartmentRepository;
import com.projects.example.customer.model.Department;
import com.projects.example.customer.model.DepartmentDTO;
import com.projects.example.customer.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department getDepartmentByName(String deptName) {
        return departmentRepository.findDepartmentByDeptName(deptName);
    }

    @Override
    public List<Department> postDepartments(List<DepartmentDTO> departments) {

        List<Department> returnDepartments = new ArrayList<>();

        departments.forEach(departmentDTO -> {
            Department department = new Department();
            department.setDeptName(departmentDTO.getDepartmentName());
            department.setLocation(departmentDTO.getLocation());
            returnDepartments.add(departmentRepository.save(department));
        });

        return returnDepartments;
    }

    @Override
    public void updateDepartments(List<DepartmentDTO> departments) {
        departments.forEach(departmentRepository::updateDepartment);
    }

}
