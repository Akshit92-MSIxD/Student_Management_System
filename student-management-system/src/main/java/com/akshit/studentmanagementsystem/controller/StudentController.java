package com.akshit.studentmanagementsystem.controller;

import com.akshit.studentmanagementsystem.dto.StudentDTO;
import com.akshit.studentmanagementsystem.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.akshit.studentmanagementsystem.service.StudentService;

@RestController
public class StudentController {

     private final  StudentService  studentService;

     public StudentController(StudentService studentService){
         this.studentService = studentService;
     }

     @PostMapping("/students")
     public Student addStudent(@RequestBody StudentDTO studentDTO){
          return studentService.addStudent(studentDTO);
    }
}
