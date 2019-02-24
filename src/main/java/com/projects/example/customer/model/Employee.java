package com.projects.example.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@Table(name = "employee")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    @ManyToOne
    private Department department;

    @Id
    @Column(name = "id")
    @JsonIgnore
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "designation")
    private String designation;

}
