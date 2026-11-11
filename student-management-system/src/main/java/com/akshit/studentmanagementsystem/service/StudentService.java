package com.akshit.studentmanagementsystem.service;

import com.akshit.studentmanagementsystem.dto.StudentDTO;
import com.akshit.studentmanagementsystem.exception.StudentNotFoundException;
import com.akshit.studentmanagementsystem.model.Student;
import com.akshit.studentmanagementsystem.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {


    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public Student getStudent(Integer id){

        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id : " + id + " not found"));
    }

    public List<Student> getAllStudents(){

         return studentRepository.findAll();
    }

    public List<Student>  getStudentsByCity(String city){
        return studentRepository.findByCity(city);
    }

    public List<Student> getStudentsByAgeGreaterThanEqual(int age)
    {
        return studentRepository.findByAgeGreaterThanEqual(age);
    }

    public List<Student> getStudentsByAgeLessThanEqual(int age)
    {
        return studentRepository.findByAgeLessThanEqual(age);
    }

    public List<Student> getStudentsByNameContaining(String name)
    {
        return studentRepository.findByNameContaining(name);
    }

    public List<Student> getStudentsByCityAndAgeGreaterThanEqual(String city,int age){
        return studentRepository.findByCityAndAgeGreaterThanEqual(city,age);
    }

    public List<Student> getStudentsByCityOrAgeGreaterThanEqual(String city,int age){
        return studentRepository.findByCityOrAgeGreaterThanEqual(city,age);
    }

    public List<Student> getAllStudentsByOrderByAgeDesc(){
        return studentRepository.findAllByOrderByAgeDesc();
    }

    public List<Student> getAllStudentsByOrderByAgeAsc(){
        return studentRepository.findAllByOrderByAgeAsc();
    }

    public List<Student> getStudentsByCityOrderByAgeDesc(String city){
        return studentRepository.findByCityOrderByAgeDesc(city);
    }

    public List<Student> getStudentsByCityOrderByAgeAsc(String city){
        return studentRepository.findByCityOrderByAgeAsc(city);
    }

    public List<Student> getTopThreeStudentsByOrderByAgeDesc(){
        return studentRepository.findTop3ByOrderByAgeDesc();
    }

    public List<Student> getTopFourStudentsByCityOrderByAgeAsc(String city){
        return studentRepository.findTop4ByCityOrderByAgeAsc(city);
    }

    public Page<Student> getAllStudentsWithPagination(int page, int size){
          Pageable pageable = PageRequest.of(page,size);
          return studentRepository.findAll(pageable);
    }

    public Student addStudent(StudentDTO dto){

         Student student = new Student();

         student.setName(dto.getName());
         student.setAge(dto.getAge());
         student.setCity(dto.getCity());
         student.setEmail(dto.getEmail());
         
          return studentRepository.save(student);
    }


    public Student updateStudent(Integer id,StudentDTO studentDTO){

         Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id : " + id + " not found"));


        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setEmail(studentDTO.getEmail());
        student.setCity(studentDTO.getCity());

        return studentRepository.save(student);
    }


    public void deleteStudent(Integer id){

            Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id : " + id + " not found"));

            studentRepository.delete(student);
    }



}
