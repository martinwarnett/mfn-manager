package com.warnett.mfnmanager.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.warnett.mfnmanager")
public class MFNManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MFNManagerApplication.class, args);
    }
}
