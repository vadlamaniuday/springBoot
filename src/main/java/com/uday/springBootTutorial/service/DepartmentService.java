package com.uday.springBootTutorial.service;

import com.uday.springBootTutorial.entity.Department;
import com.uday.springBootTutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException;


    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);


    Department fetchDepartmentByName(String departmentName);
}
