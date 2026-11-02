package com.akshit.studentmanagementsystem.dto;

import jakarta.validation.constraints.*;

public class StudentDTO {


    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value=1,message="Age must be greater than 0")
    private Integer age;

    @NotBlank(message = "email cannot be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message="city cannot be blank")
    private String city;


    public StudentDTO(){

    }

    public StudentDTO(String name,Integer age,String email,String city){
         this.name = name;
         this.age = age;
         this.email = email;
         this.city = city;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }


    @Override
    public String toString(){
        return "StudentDTO{name='"+name+"', age="+age+", email='"+email+"', city='"+city+"'}";
    }


}
