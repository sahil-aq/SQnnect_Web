package com.trainee.sqnnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class SQnnectWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SQnnectWebApplication.class,args);
	}

}
