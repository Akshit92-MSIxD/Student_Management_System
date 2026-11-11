package com.akshit.studentmanagementsystem.dto;

import com.akshit.studentmanagementsystem.model.Student;

import java.util.List;

public class StudentPageResponse {

     private List<Student> students;
     private int currentPage;
     private int pageSize;
     private long totalElements;
     private int totalPages;
     private boolean lastPage;

     public StudentPageResponse(){}

     public StudentPageResponse(List<Student> students,int currentPage,int pageSize,long totalElements, int totalPages,boolean lastPage){

          this.students = students;
          this.currentPage = currentPage;
          this.pageSize = pageSize;
          this.totalElements = totalElements;
          this.totalPages = totalPages;
          this.lastPage = lastPage;
     }

     public List<Student> getStudents(){return students;}
     public void setStudents(List<Student> students){this.students = students;}

     public int getCurrentPage(){return currentPage;}
     public void setCurrentPage(int currentPage){this.currentPage = currentPage;}

     public int getPageSize(){return pageSize;}
     public void setPageSize(int pageSize){this.pageSize = pageSize;}

     public long getTotalElements(){return totalElements;}
     public void setTotalElements(long totalElements){this.totalElements = totalElements;}

     public int getTotalPages(){return totalPages;}
     public void setTotalPages(int totalPages){this.totalPages = totalPages;}

     public boolean isLastPage(){return lastPage;}
     public  void setLastPage(boolean lastPage){this.lastPage = lastPage;}



}
