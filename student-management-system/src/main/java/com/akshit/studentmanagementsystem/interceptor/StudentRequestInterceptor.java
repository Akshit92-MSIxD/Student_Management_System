package com.akshit.studentmanagementsystem.interceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class StudentRequestInterceptor implements HandlerInterceptor{

     @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

         System.out.println("Before Controller");
         System.out.println("Dispatcher Type : " + request.getDispatcherType());
         System.out.println("Handler: " + handler);
         return true;
     }


     @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler, ModelAndView modelAndView) throws Exception{
         System.out.println("After Controller");

         if(modelAndView != null){
             System.out.println(modelAndView.getViewName());
         }
         else {
             System.out.println("No View - Rest API");
         }
     }


     @Override
     public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler,Exception ex) throws Exception{

         System.out.println("Request Completed");

          if(ex != null){
              System.out.println(ex.getMessage());
          }
          else {
              System.out.println("HTTP Status : " + response.getStatus());
          }
     }

}
