package com.akshit.studentmanagementsystem.service;

import com.akshit.studentmanagementsystem.dto.StudentDTO;
import com.akshit.studentmanagementsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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



}
