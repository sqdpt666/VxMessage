package com.pt.vx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
public class VxMessageMain {
    public static void main(String[] args) {
        SpringApplication.run(VxMessageMain.class,args);
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }
}
