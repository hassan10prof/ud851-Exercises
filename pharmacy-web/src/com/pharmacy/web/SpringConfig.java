package com.pharmacy.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = { "com.pharmacy.web", "com.pharmacy.service.Impl", "com.pharmacy.dao" })
@Configuration
public class SpringConfig {

}
