package com.akshit.studentmanagementsystem.controller;

import com.akshit.studentmanagementsystem.dto.StudentDTO;
import com.akshit.studentmanagementsystem.model.Student;
import org.springframework.web.bind.annotation.*;
import com.akshit.studentmanagementsystem.service.StudentService;

import java.util.List;

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

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Integer id){
         return studentService.getStudent(id);
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
         return studentService.getAllStudents();
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Integer id,@RequestBody StudentDTO studentDTO){
         return studentService.updateStudent(id,studentDTO);
    }
}
