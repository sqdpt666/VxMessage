package com.pt.vx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VxMessageMain {

    public static void main(String[] args) {
        SpringApplication.run(VxMessageMain.class,args);
    }
}
