package com.akshit.studentmanagementsystem.config;

import com.akshit.studentmanagementsystem.interceptor.StudentRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

      @Override
      public void addInterceptors(InterceptorRegistry registry){
          registry.addInterceptor(new StudentRequestInterceptor()).addPathPatterns("/students/**").excludePathPatterns("/students/all");
      }
}
