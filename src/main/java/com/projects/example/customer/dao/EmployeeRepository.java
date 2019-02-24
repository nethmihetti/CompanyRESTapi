package com.projects.example.customer.dao;

import com.projects.example.customer.model.Employee;
import com.projects.example.customer.model.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



    @Query(value = "from Employee emp WHERE emp.firstName= :#{#firstName}")
    List<Employee> getEmployeeByFirstName(@Param("firstName") String firstName);

    List<Employee> findAll();

   // List<Employee> getEmployeeByFirstName (String firstName);

    List<Employee> findEmployeeByDepartmentDeptName(String departmentName);

    @Modifying
    @Query(value = "insert into employee (first_name, last_name, designation, department_id)\n" +
            "VALUES\n" +
            "(:#{#employee.firstName}, :#{#employee.lastName}, :#{#employee.designation}," +
            "(select id from department where dept_name = :#{#employee.department.departmentName}))", nativeQuery = true)
    @Transactional
    void postEmployee(@Param("employee")EmployeeDTO employee);

}


