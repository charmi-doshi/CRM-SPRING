package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication

public class ClientManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientManagementSystemApplication.class, args);
		System.out.println("crm start");
	}

	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}
}
