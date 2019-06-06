package com.projects.example.customer.controller;


import com.projects.example.customer.model.Department;
import com.projects.example.customer.model.DepartmentDTO;
import com.projects.example.customer.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/company")
@Api(value = "Department Service APIs", tags = {"Department Service Controller"})
public class DepartmentController {

    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @ApiOperation(value = "Get all the details of a department by its name",
            notes = "Retrieve department details of a particular department for the departmentName",
            response = Department.class, responseContainer = "List"
    )
    @GetMapping(value = "/dept", produces = MediaType.APPLICATION_JSON_VALUE)
    public Department getDepartmentByName (@ApiParam(value = "Department Name", required = true)
                                               @RequestParam("dept_name") String deptName) {

        return departmentService.getDepartmentByName(deptName);
    }

    @PostMapping(value = "/dept", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Department> postDepartment (@RequestBody List<DepartmentDTO> departments) {
        return departmentService.postDepartments(departments);
    }

    @PutMapping(value = "/dept", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment (@RequestBody List<DepartmentDTO> departments) {
        departmentService.updateDepartments(departments);
    }

}
