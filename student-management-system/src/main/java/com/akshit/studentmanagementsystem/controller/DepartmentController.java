package com.akshit.studentmanagementsystem.controller;

import com.akshit.studentmanagementsystem.dto.DepartmentRequestDTO;
import com.akshit.studentmanagementsystem.model.Department;
import com.akshit.studentmanagementsystem.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable Integer id){
         return departmentService.getDepartment(id);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO){
        return departmentService.addDepartment(departmentRequestDTO);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO, @PathVariable Integer id){
        return departmentService.updateDepartment(departmentRequestDTO,id);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable Integer id){
         departmentService.deleteDepartment(id);
    }


}
