package com.akshit.studentmanagementsystem.service;

import com.akshit.studentmanagementsystem.dto.DepartmentRequestDTO;
import com.akshit.studentmanagementsystem.exception.DepartmentNotFoundException;
import com.akshit.studentmanagementsystem.model.Department;
import com.akshit.studentmanagementsystem.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {

     private final DepartmentRepository departmentRepository;

     public DepartmentService(DepartmentRepository departmentRepository) {
         this.departmentRepository = departmentRepository;
     }

    public  Department getDepartment(Integer id){
         return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department with id : "+id+" not found !!!"));
     }

     public List<Department> getDepartments(){
         return departmentRepository.findAll();
     }


     public Department addDepartment(DepartmentRequestDTO departmentRequestDTO){

         Department department = new Department();

         department.setName(departmentRequestDTO.getName());

         return departmentRepository.save(department);

     }

     @Transactional // now persistence context works until this method ends since now this whole method acts as one transaction :)
         // No need to use .save() , when we are using @Transactional -> Whole service method will be cosnidered as one trasaction and individual repository method trasactions becomes the part of this single transaction :)
     public Department updateDepartment(DepartmentRequestDTO departmentRequestDTO, Integer id){

         Department department = departmentRepository.findById(id).orElseThrow(()-> new DepartmentNotFoundException("Department with id : "+id+"not found !!!"));

         department.setName(departmentRequestDTO.getName());

         return department;

     }


     @Transactional
    public void deleteDepartment(Integer id){

         Department department = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department with id : "+id+"not found !!!"));

         departmentRepository.delete(department);

     }



}
