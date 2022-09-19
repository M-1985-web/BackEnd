package com.apportfolio.mmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//desde aca las nuevas
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
public class MmmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmmApplication.class, args);
	}


	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Bean
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("https://frontendmmm.web.app/")
						.allowedMethods("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization", "Origin, Accept", "X-Requested-with", "Access-Control-Request-Method", "Access-Control-Request-Headers")
						.allowedHeaders("Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
			}
		};

	}

}
