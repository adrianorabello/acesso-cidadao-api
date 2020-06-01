package com.bi.biproxyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.bi.biproxyapi.config.property.BiproxyProperty;


@SpringBootApplication
@EnableConfigurationProperties(BiproxyProperty.class)
public class BiproxyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiproxyApiApplication.class, args);
	}

	
	
	
	

	
	
}

