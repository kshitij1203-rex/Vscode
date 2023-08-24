package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByFname(String value);

    @Query("SELECT manid FROM Employee WHERE dep = :deptid")
    Integer findBydeptId(Integer deptid);

}