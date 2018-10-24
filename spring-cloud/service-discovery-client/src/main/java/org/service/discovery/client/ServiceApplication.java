package org.service.discovery.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@ConfigurationProperties
public class ServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
