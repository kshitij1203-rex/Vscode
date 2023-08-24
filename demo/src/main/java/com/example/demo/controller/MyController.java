package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.entity.Department;
import com.example.demo.service.MyService;

@Controller
public class MyController {

    @Autowired
    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }



    
    @GetMapping("/vscode")
    public String showDepartments(Model model) {
        model.addAttribute("departments", myService.getAllDepartments());
        return "departments"; // Thymeleaf template name
    }

   @GetMapping("/vscode/add-entry")
    public String showAddEntryForm(Model model) {

            // Calculate the new department ID by finding the maximum department ID and incrementing it
    Integer maxDepartmentId = myService.getMaxDepartmentId(); 
    Integer newDepartmentId = maxDepartmentId != null ? maxDepartmentId + 1 : 1;

        // Prepare an empty ProjectDTO object for the form
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setDepartmentId(newDepartmentId);
        model.addAttribute("projectDTO", projectDTO);
        
        return "add-entry"; // Return the name of the HTML template
    }

    @PostMapping("/vscode")
    public String saveDepartment(@Valid @ModelAttribute("projectDTO") ProjectDTO projectDTO, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("my form has errors");
            return "add-entry";
        }
        else{
            myService.saveDepartment(projectDTO);
        return "redirect:/vscode";
        }
         // Redirect to the department list page
    }


    @GetMapping("/vscode/department")
    @ResponseBody
    public ProjectDTO showDepartmentDetails(@RequestParam("Id") Integer Id, Model model) {
        ProjectDTO projectDTO = myService.getDepartmentById(Id);
            System.out.println(projectDTO);
            model.addAttribute("department", projectDTO);
            return myService.getDepartmentById(Id); 
        
    }



    @GetMapping("/department")
    public String editDepartment(@RequestParam("Id") Integer departmentId, Model model) {
        ProjectDTO department = myService.getDepartmentById(departmentId);
        List<Department> otherDepartments = myService.getOtherDepartments(departmentId);
        
        model.addAttribute("department", department);
        model.addAttribute("otherDepartments", otherDepartments);
        
        return "edit-department"; // Replace with your HTML template name
    }



    @PostMapping("/department/update")
    public String updateDepartment(@ModelAttribute("department") ProjectDTO departmentDTO) {
        myService.updateDepartment(departmentDTO);
        return "redirect:/vscode"; // Redirect to the department list page
    }

    @GetMapping("/department/delete")
    public String confirmDeleteDepartment(@RequestParam("Id") Integer departmentId, Model model) {
        ProjectDTO department = myService.getDepartmentById(departmentId);
        
        // model.addAttribute("department", department);
        
        return "confirm-delete"; // Replace with your HTML template name
    }

    @PostMapping("/department/delete")
    public String deleteDepartment(@RequestParam("Id") Integer departmentId) {
        myService.deleteDepartmentById(departmentId);
        return "redirect:/vscode"; // Redirect back to the department list
    }



















//     @RequestMapping(value="/vscode/update-entry", method = {RequestMethod.PUT, RequestMethod.GET})
//     public String updateDepartment(@ModelAttribute("projectDTO") ProjectDTO projectDTO) {
//     myService.updateDepartment(projectDTO);
//     return "redirect:/vscode"; // Redirect to the department list page
// }


//     @RequestMapping(value="/vscode/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
//     public String deleteDepartment(@RequestParam("Id") Integer Id) {
//     myService.deleteDepartmentById(Id);
//     return "redirect:/vscode"; // Redirect back to the department list
// }


//Employee page
    @GetMapping("/vscode/employee")
    public String showEmployeePage(@RequestParam("Id") Integer Id,Model model) {
        model.addAttribute("departments", myService.getDepartmentById(Id));
        return "employee"; // Thymeleaf template name
    }

    
    


}
