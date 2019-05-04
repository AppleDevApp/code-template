package com.codebox.codetemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.codebox.codetemplate.mapper")
public class CodeTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeTemplateApplication.class, args);
    }

}
