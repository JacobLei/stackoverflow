package com.jacob.stackoverflow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jacob.stackoverflow.mapper")
public class StackoverflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowApplication.class, args);
    }
}
