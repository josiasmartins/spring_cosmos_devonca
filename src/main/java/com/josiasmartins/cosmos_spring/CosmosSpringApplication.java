package com.josiasmartins.cosmos_spring;

//import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCosmosRepositories(basePackages = "com.josiasmartins.cosmos_spring.repository")
public class CosmosSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmosSpringApplication.class, args);
	}

}
