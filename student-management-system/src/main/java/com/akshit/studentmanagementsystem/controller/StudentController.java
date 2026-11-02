package com.akshit.studentmanagementsystem.controller;

import com.akshit.studentmanagementsystem.dto.StudentDTO;
import com.akshit.studentmanagementsystem.model.Student;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.akshit.studentmanagementsystem.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

     private final  StudentService  studentService;

     public StudentController(StudentService studentService){
         this.studentService = studentService;
     }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Integer id){
         return studentService.getStudent(id);
    }


     @PostMapping("/students")
     public Student addStudent(@Valid @RequestBody StudentDTO studentDTO){
          return studentService.addStudent(studentDTO);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
         return studentService.getAllStudents();
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@Valid @PathVariable Integer id,@RequestBody @Valid StudentDTO studentDTO){
         return studentService.updateStudent(id,studentDTO);
    }

    @DeleteMapping("/students/{id}")
   public void deleteStudent(@PathVariable Integer id){
         studentService.deleteStudent(id);
    }

}
