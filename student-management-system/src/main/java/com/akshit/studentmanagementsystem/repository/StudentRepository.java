package com.akshit.studentmanagementsystem.repository;

import com.akshit.studentmanagementsystem.dto.StudentBasicDTO;
import com.akshit.studentmanagementsystem.dto.StudentBasicInfo;
import com.akshit.studentmanagementsystem.model.Student;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

         // We dont need to declare these two methods since they are inherted from JpaRepo :)
//       Page<Student> findAll(Pageable pageable);
//         List<Student> findAll(Sort sort);

       List<StudentBasicInfo> findAllProjectedBy();  // Interface based Projection
       List<StudentBasicDTO> findAllBy();  // Class Based Projection

//        JPQL (work on only java entities and their properties :) -> later converted into SQL by Hibernate :)

       // JPQL Query - using JOIN (fetches the entity but  delays its association until needed or does not delay it if EAGER fetching strategy is set :)
       @Query("SELECT s from Student s JOIN s.department d where d.name = :departmentName")
       List<Student> getStudentsByDepartment(@Param("departmentName") String departmentName);

       // JPQL Query - using JOIN FETCH (fetches the entity and its association eagerly even if LAZY fetching strategy is set :)
       @Query("SELECT s from Student s JOIN FETCH s.department where s.department.name = :departmentName")
       List<Student> getStudentsByDepartmentFetched(@Param("departmentName") String departmentName);


       // To solve N+1 select problem -> "JOIN FETCH" to fetch all students along with their department association in One query :)
       @Query("SELECT s from Student s JOIN FETCH s.department")
       List<Student> getAllStudentsWithDepartmentFetched();




}
