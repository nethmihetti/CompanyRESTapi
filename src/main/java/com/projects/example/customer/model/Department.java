package com.projects.example.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@Table(name = "department")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

    @Id
    @Column(name = "id")
    @JsonIgnore
    private Integer id;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "location")
    private String location;
}
