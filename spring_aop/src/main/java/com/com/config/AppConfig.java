package com.com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.com")
@EnableAspectJAutoProxy //imp hey spring + aspectJ
public class AppConfig {
}
