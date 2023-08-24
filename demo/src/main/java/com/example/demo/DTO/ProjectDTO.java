package com.example.demo.DTO;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ProjectDTO {

    private Integer departmentId;

    @NotBlank(message = "Department name is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Department name must contain only alphanumeric characters")
    private String departmentName;
   
    private String managerName;
    private String city;
    public Integer getDepartmentId() {
        return departmentId;




        
    }
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public ProjectDTO(){

    }

    public ProjectDTO(Integer departmentId, String departmentName, String managerName, String city) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerName = managerName;
        this.city = city;
    }
    
}
