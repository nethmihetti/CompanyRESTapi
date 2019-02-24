package com.projects.example.customer.dao;

import com.projects.example.customer.model.Department;
import com.projects.example.customer.model.DepartmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findDepartmentByDeptName(String deptName);

    @Modifying
    @Query(value = "insert into department (dept_name, location)\n" +
            "VALUES\n" +
            "(:#{#department.departmentName}, :#{#department.location})", nativeQuery = true)
    @Transactional
    void postDepartment(@Param("department")DepartmentDTO department);

    @Modifying
    @Query(value = "update department\n" +
    "set department.location = :#{#department.location} where department.dept_name = :#{#department.departmentName}", nativeQuery = true)
    @Transactional
    void updateDepartment(@Param("department")DepartmentDTO department);



}
