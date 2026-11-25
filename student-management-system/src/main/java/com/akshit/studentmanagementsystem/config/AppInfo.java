package com.akshit.studentmanagementsystem.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @Value  is Convenient for a few values :)
//@Component
//public class AppInfo {
//
//    @Value("${student.app.name}")  // read values from application.properties file and inject to this field
//    private String appName;
//
//    @Value("${student.app.version}")
//    private String version;
//
//    @Value("${student.app.max-students}")
//    private int maxStudents;
//
//    public String getAppName(){
//        return appName;
//    }
//
//    public String getVersion(){
//        return version;
//    }
//
//    public int getMaxStudents(){
//        return maxStudents;
//    }
//
//    @PostConstruct
//    public void displayInfo(){
//
//        System.out.println("====================APPLICATION INFO==================");
//        System.out.println("Application Name : " + appName);
//        System.out.println("Version : " + version);
//        System.out.println("Maximum Students : " + maxStudents);
//
//    }
//}


// @ConfigurationProperties is Better for larger configurations :)
//@Component
@ConfigurationProperties(prefix = "student.app") // Binds external properties to Java fields
public class AppInfo {

    private String name;
    private String version;
    private int maxStudents;

    public String getName(){
        return name;
    }

    public void setName(String name){this.name = name;}

    public String getVersion(){
        return version;
    }

    public void setVersion(String version){this.version = version;}

    public int getMaxStudents(){
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents){this.maxStudents = maxStudents;}


    @PostConstruct
    public void displayInfo(){

        System.out.println("====================APPLICATION INFO==================");
        System.out.println("Application Name : " + name);
        System.out.println("Version : " + version);
        System.out.println("Maximum Students : " + maxStudents);

    }

}
