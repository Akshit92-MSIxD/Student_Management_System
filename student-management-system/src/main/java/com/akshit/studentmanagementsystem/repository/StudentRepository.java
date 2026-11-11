package com.akshit.studentmanagementsystem.repository;

import com.akshit.studentmanagementsystem.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

       List<Student> findByCity(String city);
       List<Student> findByAgeGreaterThanEqual(int age);
       List<Student> findByAgeLessThanEqual(int age);
       List<Student> findByNameContaining(String name);
       List<Student> findByCityAndAgeGreaterThanEqual(String city, int age);
       List<Student> findByCityOrAgeGreaterThanEqual(String city,int age);
       List<Student> findAllByOrderByAgeDesc();
       List<Student> findAllByOrderByAgeAsc();
       List<Student> findByCityOrderByAgeDesc(String city);
       List<Student> findByCityOrderByAgeAsc(String city);
       List<Student> findTop3ByOrderByAgeDesc();
       List<Student> findTop4ByCityOrderByAgeAsc(String city);

       Page<Student> findAll(Pageable pageable);
}
