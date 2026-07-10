package com.akshit.studentmanagementsystem.service;

import com.akshit.studentmanagementsystem.dto.StudentDTO;
import com.akshit.studentmanagementsystem.exception.StudentNotFoundException;
import com.akshit.studentmanagementsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {

   private HashMap<Integer, Student> students = new HashMap<>();
   private Integer nextId = 1;

    public Student addStudent(StudentDTO dto){

         Student student = new Student(nextId,dto.getName(),dto.getAge(),dto.getEmail(),dto.getCity());

         students.put(nextId,student);

         nextId++;

         return student;
    }

    public Student getStudent(Integer id){

         Student student = students.get(id);

         if(student == null)
         {
             throw new StudentNotFoundException("Student with id "+ id + " not found");
         }

         return student;
    }

    public List<Student> getAllStudents(){

         return new ArrayList<>(students.values());
    }



}
