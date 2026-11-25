package com.akshit.studentmanagementsystem.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class GreetingRunner {

    private final AppGreeting appGreeting;

    public GreetingRunner(AppGreeting appGreeting){
        this.appGreeting = appGreeting;
    }


    @PostConstruct
    public void displayMessage(){
        System.out.println(appGreeting.getMessage());
    }
}


