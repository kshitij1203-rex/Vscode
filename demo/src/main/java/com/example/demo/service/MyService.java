package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Location;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LocationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MyService {

    @Autowired
    public DepartmentRepository departmentrepository;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public LocationRepository locationRepository;

    public MyService(DepartmentRepository departmentrepository, EmployeeRepository employeeRepository,
            LocationRepository locationRepository) {
        this.departmentrepository = departmentrepository;
        this.employeeRepository = employeeRepository;
        this.locationRepository = locationRepository;
    }

    public List<ProjectDTO> getAllDepartments() {
        return departmentrepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Integer getMaxDepartmentId() {
        return departmentrepository.findMaxDepartmentId();
    }



    

    // public void saveDepartment(ProjectDTO projectDTO) {
    // Employee manager = new Employee(projectDTO.getManagerName(), null, null, null, null, null, null, null, null, null); // Department will be set later
    // employeeRepository.save(manager);

    // Location location = new Location(projectDTO.getCity(), null, null, null, null);
    // locationRepository.save(location);

    // Department department = new Department(projectDTO.getDepartmentName(), manager, location);
    // departmentrepository.save(department);
    // }

    public void saveDepartment(ProjectDTO projectDTO) {
        Employee manager = null;
        if (projectDTO.getManagerName() != "") {
            Employee managers = employeeRepository.findByFname(projectDTO.getManagerName());
            if(managers == null){
                
            }
            manager = new Employee(projectDTO.getManagerName(), null, null, null, null, null, null, null, null, null);
            employeeRepository.save(manager);
        }

        Location location = null;
        if (projectDTO.getCity() != "") {
            location = new Location(projectDTO.getCity(), null, null, null, null);
            locationRepository.save(location);
        }

        Department department = new Department(projectDTO.getDepartmentName(), manager, location);
        System.out.println(department);
        departmentrepository.save(department);
    }





    public ProjectDTO getDepartmentById(Integer departmentId) {
        System.out.println(departmentId);
        Department department = departmentrepository.findById(departmentId).orElse(null);
        if (department != null) {
            return convertToDto(department);
        }
        return null; // Department not found
    }






    public void updateDepartment(ProjectDTO projectDTO) {
    Department department = departmentrepository.findById(projectDTO.getDepartmentId())
    .orElseThrow(() -> new EntityNotFoundException("Department not found"));

    Employee manager = department.getEmp();
    manager.setFname(projectDTO.getManagerName()); // Update manager name

    Location location = department.getLoc();
    location.setCity(projectDTO.getCity()); // Update city

    department.setDname(projectDTO.getDepartmentName()); // Update department name

    employeeRepository.save(manager);
    locationRepository.save(location);
    departmentrepository.save(department);
}


// public void updateDepartment(ProjectDTO projectDTO) {
//     Department department = departmentrepository.findById(projectDTO.getDepartmentId())
//             .orElseThrow(() -> new EntityNotFoundException("Department not found"));

//     Employee manager = department.getEmp();

//     if (manager != null) {
//         // Update manager's information
//         manager.setFname(projectDTO.getManagerName());
//         // ... update other manager properties if needed
//         employeeRepository.save(manager);
//     }

//     Location location = department.getLoc();
//     if (location != null) {
//         // Update location information
//         location.setCity(projectDTO.getCity());
//         // ... update other location properties if needed
//         locationRepository.save(location);
//     }

//     department.setDname(projectDTO.getDepartmentName()); // Update department name
//     departmentrepository.save(department);
// }




    // ... (other methods and dependencies)

    public void deleteDepartmentById(Integer departmentId) {

        Integer manid = employeeRepository.findBydeptId(departmentId);
        employeeRepository.deleteById(manid);
        departmentrepository.deleteById(departmentId);
    }





    // private ProjectDTO convertToDto(Department department) {
    //     ProjectDTO dto = new ProjectDTO();
    //     dto.setDepartmentId(department.getDeptid());
    //     dto.setDepartmentName(department.getDname());
    //     dto.setManagerName(department.getEmp().getFname());
    //     dto.setCity(department.getLoc().getCity());
    //     return dto;
    // }

//     private ProjectDTO convertToDto(Department department) {
//         ProjectDTO dto = new ProjectDTO();
//         dto.setDepartmentId(department.getDeptid());
//         dto.setDepartmentName(department.getDname());
        
//         if (department.getEmp() != null) {
//             dto.setManagerName(department.getEmp().getFname());
//         }
        
//         if (department.getLoc() != null) {
//             dto.setCity(department.getLoc().getCity());
//         }
        
//         return dto;

    
// }

private ProjectDTO convertToDto(Department department) {
    ProjectDTO dto = new ProjectDTO();
    dto.setDepartmentId(department.getDeptid());

    // Set Department Name (No validation needed here)
    dto.setDepartmentName(department.getDname());

    // Set Manager Name if it's not null
    if (department.getEmp() != null && department.getEmp().getFname() != null) {
        dto.setManagerName(department.getEmp().getFname());
    }

    // Set City if it's not null
    if (department.getLoc() != null && department.getLoc().getCity() != null) {
        dto.setCity(department.getLoc().getCity());
    }

    return dto;
}

public List<Department> getOtherDepartments(Integer departmentId) {
    return null;
}



}

