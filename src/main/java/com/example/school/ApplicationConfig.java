package com.example.school;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.*")
@MapperScan(basePackages = "com.example.mapper")
public class ApplicationConfig{


    
}