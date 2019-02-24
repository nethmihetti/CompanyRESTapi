package com.projects.example.customer.controller;


import com.projects.example.customer.model.Department;
import com.projects.example.customer.model.DepartmentDTO;
import com.projects.example.customer.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/company")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "dept", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Department getDepartmentByName (@RequestParam("dept_name") String deptName) {

        return departmentService.getDepartmentByName(deptName);
    }

    @RequestMapping(value = "dept", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void postDepartment (@RequestBody List<DepartmentDTO> departments) {
        departmentService.postDepartments(departments);
    }

    @RequestMapping(value = "dept", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment (@RequestBody List<DepartmentDTO> departments) {
        departmentService.updateDepartments(departments);
    }

}
