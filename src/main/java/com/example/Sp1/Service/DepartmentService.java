package com.example.Sp1.Service;

import com.example.Sp1.Error.DepartmentNotFoundException;
import com.example.Sp1.Entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);


    public List<Department> fetchDepartmentList();

     public Department fetchDepartmentById(Long departmentById) throws DepartmentNotFoundException;


    public void deleteDepartmentById(Long departmentId);

     Department updateDepartmentsById(Long departmentId, Department department);


  public   Department fetchDepartmentByName(String departmentName);
}
