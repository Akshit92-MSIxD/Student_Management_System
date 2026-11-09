package com.akshit.studentmanagementsystem.filter;

import jakarta.servlet.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class RequestValidationFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
         System.out.println("Before Request");
         chain.doFilter(request,response);
        System.out.println("After Request");
    }
}
