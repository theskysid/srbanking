package com.theskysid.backendbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BackendBankApplication {

    public static void main(String[] args) {

        // ApplicationContext context = SpringApplication.run(BackendBankApplication.class, args); //stores beans in context which is of type ApplicationContext
        SpringApplication.run(BackendBankApplication.class, args);

    }

}
