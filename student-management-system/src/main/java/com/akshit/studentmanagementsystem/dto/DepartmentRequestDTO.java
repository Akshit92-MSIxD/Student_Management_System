package com.akshit.studentmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDTO {

    @NotBlank(message="Name cannot be blank")
    String name;

    public DepartmentRequestDTO(String name) {
        this.name = name;
    }

        public String getName(){
            return name;
        }

       public void setName(String name){
            this.name = name;
        }


    }
