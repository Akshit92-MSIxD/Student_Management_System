package com.akshit.studentmanagementsystem.controller;

import com.akshit.studentmanagementsystem.dto.StudentBasicDTO;
import com.akshit.studentmanagementsystem.dto.StudentBasicInfo;
import com.akshit.studentmanagementsystem.dto.StudentRequestDTO;
import com.akshit.studentmanagementsystem.dto.StudentPageResponse;
import com.akshit.studentmanagementsystem.model.Student;
import com.akshit.studentmanagementsystem.service.EntityLifecycleExperimentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.akshit.studentmanagementsystem.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

     private final  StudentService  studentService;
     private final  EntityLifecycleExperimentService e;

     public StudentController(StudentService studentService, EntityLifecycleExperimentService e){
         this.studentService = studentService;
         this.e = e;
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

    // Pagination
    @GetMapping("/students/paginated")
    public StudentPageResponse getAllStudentsWithPagination(@RequestParam int page, @RequestParam int size){
         return studentService.getAllStudentsWithPagination(page,size);
    }

   // Dynamic sorting
     @GetMapping("/students/sorted")
     public List<Student> getAllStudentsWithSorting(@RequestParam String sortBy, @RequestParam String direction){
          return studentService.getAllStudentsWithSorting(sortBy,direction);
     }

     // Pagination + Dynamic Sorting
     @GetMapping("/students/paginated-sorted")
     public StudentPageResponse getAllStudentsWithPaginationAndSorting(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy, @RequestParam String direction){
         return studentService.getAllStudentsWithPaginationAndSorting(page,size,sortBy,direction);
     }

     // Interface based Projection (StudentBasicInfo is an interface declared in DTO package)
    @GetMapping("/students/basic-info")
    public List<StudentBasicInfo> getAllStudentsBasicInfo(){
         return studentService.getAllStudentsBasicInfo();
    }

    // Class Bases Projection (StudentBasicDTO is a class declared in DTO package)
    @GetMapping("/students/basic-dto")
    public List<StudentBasicDTO> getAllStudentsBasicDTO(){
         return studentService.getAllStudentsBasicDTO();
    }

    // Entity Lifecycle Test - 1
    @GetMapping("/students/transistentToPersistent-test")
    public String testTransientToPersistent(){

         e.testTransientToPersistent();
         return "Transient to Persistent test completed";

    }

    // Entity Lifecycle Test - 2
    @GetMapping("/students/persistentToDetach-test1")
    public String testPersistentToDetach1(){
         e.testPersistentToDetach1();
         return "Persistent to Detach test1 completed";
    }

    // Entity Lifecycle Test - 3
    @GetMapping("/students/persistentToDetach-test2")
    public String testPersistentToDetach2(){
         e.testPersistentToDetach2();
         return "Persistent to Detach test2 completed";
    }

    // Entity Lifecycle Test - 4
    @GetMapping("/students/persistentToDetachToPersistent-test")
    public String testPersistentToDetachedToPersistent(){
         e.testPersistentToDetachToPersistent();
         return "Persistent to Detach to Persistent test completed";
    }

    // Test Lazy Loading (Relationship -> @ManyToOne from student to Department) (Please change fetch = FetchType.LAZY in student class for department field :)

    @GetMapping("/students/{studentId}/test-lazy-loading")
    public String testLazyLoading(@PathVariable Integer studentId){
        studentService.testLazyLoading(studentId);

         return "Lazy Loading test completed";
    }

    // Test Eager Loading (Relationship -> @ManyOne from studen to Department) (Please change fetch = FetchType.EAGER in student class for department field :)

    @GetMapping("/students/{studentId}/test-eager-loading")
    public String testEagerLoading(@PathVariable Integer studentId){
         studentService.testEagerLoading(studentId);

         return "Eager Loading test completed";
    }

    // This method is indirectly associated with JPQL in the studentRepository :)

    @GetMapping("/students/department")
    public List<Student> getStudentsByDepartment(@RequestParam String name){
         return studentService.getStudentsByDepartment(name);
    }

    // This method is indirectly associated with JPQL in the studentRepository :)

    @GetMapping("/students/department/fetched")
    public List<Student> getStudentsByDepartmentFetched(@RequestParam String name){
         return studentService.getStudentsByDepartmentFetched(name);
    }

    // N+1 select problem
    @GetMapping("/students/test-n-plus-one")
     public String  testNplusOne(){
         studentService.testNplusOne();

         return "N+1 query test completed.";
     }
     // Avoids or Solve N+1 select problem :)
    @GetMapping("/students/with-department-fetched")
    public List<Student> getAllStudentsWithDepartmentFetched() {
        return studentService.getAllStudentsWithDepartmentFetched();
    }

    // Batch Fetching -> one of the ways to reduce or avoid or solve N+1 select queries in case we want to access the associations later :)
    @GetMapping("/students/test-batch-fetching")
    public String testBatchFetching(){
         studentService.testBatchFetching();

         return "Batch Fetching test completed to avoid or reduce N+1 select queries :)";
    }

     @PostMapping("/students")
     public Student addStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO){
          return studentService.addStudent(studentRequestDTO);
    }


    @PutMapping("/students/{id}")
    public Student updateStudent(@Valid @PathVariable Integer id,@RequestBody @Valid StudentRequestDTO studentRequestDTO){
         return studentService.updateStudent(id, studentRequestDTO);
    }

    @PutMapping("/students/{studentId}/departments/{departmentId}")
    public Student updateStudentDepartment(@PathVariable Integer studentId,@PathVariable Integer departmentId){
          return studentService.updateStudentDepartment(studentId,departmentId);
    }

    @DeleteMapping("/students/{id}")
   public void deleteStudent(@PathVariable Integer id){
         studentService.deleteStudent(id);
    }

}
