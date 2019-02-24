package com.projects.example.customer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String designation;
    private DepartmentDTO department;

}
