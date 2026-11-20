package com.akshit.studentmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Department(){}

    public Department(Integer id, String name){
          this.id = id;
          this.name = name;
    }

    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
}
