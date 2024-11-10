package com.lahiru.todoappbackend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoAppBackendApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoAppBackendApplication.class, args);
    }

}


//    Deprecated csrf() method:
//
//        http.csrf().disable()
//        New version of csrf() method:
//
//        http.csrf((csrf) -> csrf.disable())
//        In the next lecture, please use the below new csrf() method that takes lambda expression implementation to disable the CSRF feature:
//
//        http.csrf((csrf) -> csrf.disable())
