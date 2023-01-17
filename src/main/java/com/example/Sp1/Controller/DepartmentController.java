package com.example.Sp1.Controller;

import com.example.Sp1.Error.DepartmentNotFoundException;
import com.example.Sp1.Entity.Department;
import com.example.Sp1.Service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
     @Autowired
     private DepartmentService  departmentService;
     private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/Departments")
    public Department saveDepartment(@Valid@RequestBody Department  department){
        LOGGER.info("inside saveDepartment of DepartmentController");
           return departmentService.saveDepartment(department);
    }
    @GetMapping("/Departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/Departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/Departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId ){
        departmentService.deleteDepartmentById(departmentId);
        return "Deletion is successful";
    }
    @PutMapping("/Departments/{id}")
    public Department updateDepartmentsById(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartmentsById(departmentId,department);
    }
    @GetMapping("/Departments/name/{name}")
    public Department fetchDepartmentByNAme(@PathVariable ("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
