package com.felipe.dev.api;

import com.felipe.dev.api.infra.AI.config.AIProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AIProperties.class)
public class IaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IaApiApplication.class, args);
	}

}
