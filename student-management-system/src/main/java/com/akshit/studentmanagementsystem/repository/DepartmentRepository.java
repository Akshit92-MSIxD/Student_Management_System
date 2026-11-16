package com.akshit.studentmanagementsystem.repository;

import com.akshit.studentmanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
