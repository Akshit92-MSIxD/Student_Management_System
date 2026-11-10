package com.akshit.studentmanagementsystem.config;

import com.akshit.studentmanagementsystem.interceptor.AuthenticationInterceptor;
import com.akshit.studentmanagementsystem.interceptor.SecondStudentInterceptor;
import com.akshit.studentmanagementsystem.interceptor.StudentRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

       private final StudentRequestInterceptor firstInterceptor;
       private final SecondStudentInterceptor secondInterceptor;
       private final AuthenticationInterceptor thirdInterceptor;

       public WebConfig(StudentRequestInterceptor firstInterceptor, SecondStudentInterceptor secondInterceptor, AuthenticationInterceptor thirdInterceptor){
           this.firstInterceptor = firstInterceptor;
           this.secondInterceptor = secondInterceptor;
           this.thirdInterceptor = thirdInterceptor;
       }

      @Override
      public void addInterceptors(InterceptorRegistry registry){
          registry.addInterceptor(thirdInterceptor).addPathPatterns("/students/**").excludePathPatterns("/students");
          registry.addInterceptor(firstInterceptor).addPathPatterns("/students/**");
          registry.addInterceptor(secondInterceptor).addPathPatterns("/students/**");
      }
}
