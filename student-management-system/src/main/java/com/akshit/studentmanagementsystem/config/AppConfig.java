package com.akshit.studentmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks the class as a source of bean definitions.
public class AppConfig {

    @Bean  // Marks a method whose returned object should be registered as a Spring bean. and returned object's name is based on the name of the method that has provided it to the spring like appGreeting in this case :)
    public AppGreeting appGreeting(){
        return new AppGreeting();
    }
}
