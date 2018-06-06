package com.nh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootJpaCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaCacheApplication.class, args);
	}
}
