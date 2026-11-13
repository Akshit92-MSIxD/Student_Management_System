package com.akshit.studentmanagementsystem.dto;

public class StudentBasicDTO {

    private final String name;
    private final String email;

    public StudentBasicDTO(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}
