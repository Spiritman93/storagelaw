package com.storagelaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class} )
public class WebApp {

    public static void main(String[] args)
    {
        SpringApplication.run(WebApp.class, args);
    }

}
