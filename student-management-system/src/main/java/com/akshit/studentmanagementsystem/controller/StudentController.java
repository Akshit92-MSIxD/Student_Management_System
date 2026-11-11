package com.akshit.studentmanagementsystem.controller;

import com.akshit.studentmanagementsystem.dto.StudentDTO;
import com.akshit.studentmanagementsystem.dto.StudentPageResponse;
import com.akshit.studentmanagementsystem.model.Student;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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

    @GetMapping("/students")
    public List<Student> getStudents(){
         return studentService.getAllStudents();
    }

    @GetMapping("/students/city/{city}")
    public List<Student> getStudentsByCity(@PathVariable String city){
         return studentService.getStudentsByCity(city);
    }

    @GetMapping("/students/age/greater-than-equal/{age}")
    public List<Student> getStudentsByAgeGreaterThanEqual(@PathVariable int age){
         return studentService.getStudentsByAgeGreaterThanEqual(age);
    }

    @GetMapping("/students/age/less-than-equal/{age}")
    public List<Student> getStudentsByAgeLessThanEqual(@PathVariable int age){
        return studentService.getStudentsByAgeLessThanEqual(age);
    }

    @GetMapping("/students/name/search/{name}")
    public List<Student> getStudentsByNameContaining(@PathVariable String name){
         return studentService.getStudentsByNameContaining(name);
    }

    @GetMapping("/students/search/and")
    public List<Student> getStudentsByCityAndAgeGreaterThanEqual(@RequestParam String city, @RequestParam int minAge){
               return studentService.getStudentsByCityAndAgeGreaterThanEqual(city,minAge);
    }

    @GetMapping("/students/search/or")
    public List<Student> getStudentsByCityOrAgeGreaterThanEqual(@RequestParam String city,@RequestParam int minAge){
         return studentService.getStudentsByCityOrAgeGreaterThanEqual(city,minAge);
    }

    @GetMapping("/students/desc")
    public List<Student> getAllStudentsByOrderByAgeDesc(){
         return studentService.getAllStudentsByOrderByAgeDesc();
    }

    @GetMapping("/students/asc")
    public List<Student> getAllStudentsByOrderByAgeAsc(){
         return studentService.getAllStudentsByOrderByAgeAsc();
    }

    @GetMapping("/students/city/{city}/desc")
    public List<Student> getStudentsByCityOrderByAgeDesc(@PathVariable String city){
         return studentService.getStudentsByCityOrderByAgeDesc(city);
    }

    @GetMapping("/students/city/{city}/asc")
    public List<Student> getStudentsByCityOrderByAgeAsc(@PathVariable String city){
         return studentService.getStudentsByCityOrderByAgeAsc(city);
    }


    @GetMapping("/students/desc/top-3")
    public List<Student> getTopThreeStudentsByOrderByAgeDesc(){
         return studentService.getTopThreeStudentsByOrderByAgeDesc();
    }

    @GetMapping("/students/city/{city}/asc/top-4")
    public List<Student> getTopFourStudentsByCityOrderByAgeAsc(@PathVariable String city){
          return studentService.getTopFourStudentsByCityOrderByAgeAsc(city);
    }

    @GetMapping("/students/paginated")
    public Page<Student> getAllStudentsWithPagination(@RequestParam int page, @RequestParam int size){
         return studentService.getAllStudentsWithPagination(page,size);
    }





     @PostMapping("/students")
     public Student addStudent(@Valid @RequestBody StudentDTO studentDTO){
          return studentService.addStudent(studentDTO);
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
