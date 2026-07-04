package com.akshit.studentmanagementsystem.dto;

public class StudentDTO {

    private String name;
    private Integer age;
    private String email;
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
