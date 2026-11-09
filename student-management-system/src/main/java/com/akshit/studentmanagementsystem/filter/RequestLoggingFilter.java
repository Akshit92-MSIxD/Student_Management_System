
// Make sure you ask this prompt to chatgpt to revise optimally !!!

//Please prepare short, easy-to-understand notes covering the following topics:
//
//        1. Servlet API
//        2. Tomcat
//        3. Servlet Container
//        4. DispatcherServlet
//        5. Checked Exceptions
//        6. Servlet and Filter
//        7. FilterChain
//        8. ServletRequest and ServletResponse
//        9. HttpServletRequest and HttpServletResponse
//        10. Difference between throw and throws !!!
//
//        **Instructions:**
//        - Use very simple and beginner-friendly language.
//        - Include only the most important points and concepts.
//        - Explain the purpose of each component and how it works.
//        - Clearly explain the relationship between these components wherever relevant.
//        - Include the request flow to show how Tomcat, Filters, DispatcherServlet, and Controllers work together.
//        - Explicitly mention that `ServletRequest` and `ServletResponse` are interfaces, but Tomcat provides their concrete implementations at runtime.
//        - Explain that `HttpServletRequest` extends `ServletRequest` and `HttpServletResponse` extends `ServletResponse`.
//        - Include small examples wherever they help clarify a concept.
//
//        The goal is to create concise revision notes that cover all the essential concepts without unnecessary details.



package com.akshit.studentmanagementsystem.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class RequestLoggingFilter implements Filter {

    @Override
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String method = httpRequest.getMethod();
        String uri = httpRequest.getRequestURI();

        System.out.println("Incoming request : " + method + " " + uri);

        chain.doFilter(request, response);

    }
}
