package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    @Query("SELECT MAX(d.deptid) FROM Department d")
    Integer findMaxDepartmentId();

    


}