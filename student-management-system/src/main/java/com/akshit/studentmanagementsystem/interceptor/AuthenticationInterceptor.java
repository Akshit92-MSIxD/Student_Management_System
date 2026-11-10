package com.akshit.studentmanagementsystem.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
               String apiKey = request.getHeader("X-API-KEY");

               String expectedApiKey = "my-secret-key";

               if(expectedApiKey.equals(apiKey)) {
                   return true;
               }
               else {
                   response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               }
               return false;
    }


}



