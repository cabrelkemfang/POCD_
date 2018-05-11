package com.example.datamigration;

import com.example.datamigration.controller.DataMigrationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.example.datamigration")
public class DatamigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatamigrationApplication.class, args);


    }
}
