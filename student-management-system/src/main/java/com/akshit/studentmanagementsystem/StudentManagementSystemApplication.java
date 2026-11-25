package com.akshit.studentmanagementsystem;

import com.akshit.studentmanagementsystem.config.AppInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableConfigurationProperties(AppInfo.class)   // one of the ways to register @Configuration Properties class :)
@ConfigurationPropertiesScan  // By default it scans the package containing your main application class and all its subpackages. Since AppInfo is in your config subpackage, it should be discovered.
@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

}
