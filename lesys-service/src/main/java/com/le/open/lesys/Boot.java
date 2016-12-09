package com.le.open.lesys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by zliu on 16/10/26.
 */

@SpringBootApplication
public class Boot extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Boot.class);
    }
    public static void main(String[] argvs){
        SpringApplication.run(Boot.class, argvs);
    }
}
