package com.akshit.studentmanagementsystem.repository;

import com.akshit.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

       List<Student> findByCity(String city);
       List<Student> findByAgeGreaterThanEqual(int age);
       List<Student> findByAgeLessThanEqual(int age);
       List<Student> findByNameContaining(String name);
       List<Student> findByCityAndAgeGreaterThanEqual(String city, int age);
       List<Student> findByCityOrAgeGreaterThanEqual(String city,int age);
}
