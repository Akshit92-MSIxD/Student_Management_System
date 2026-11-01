package com.akshit.studentmanagementsystem.repository;

import com.akshit.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
