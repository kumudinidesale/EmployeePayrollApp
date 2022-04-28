package com.example.employee_payrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication
                .run(EmployeePayrollAppApplication.class, args);

        log.info("Employee app started in the {} Environment", context.getEnvironment().getProperty("environment"));
        log.info("Employee DB User is{}", context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
