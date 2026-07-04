package com.akshit.studentmanagementsystem.model;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String city;

    public Student(){}

    public Student(Integer id, String name, Integer age, String email, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email  = email;
        this.city = city;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return this.age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Override
    public String toString(){
        return "Student{id="+id+", name='"+name+"', age="+age+", email='"+email+"', city='"+city+"'}";
    }
}
