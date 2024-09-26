package com.josiasmartins.cosmos_spring.config;


import com.azure.data.cosmos.CosmosKeyCredential;
//import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
//import lombok.Value;
import com.microsoft.azure.spring.data.cosmosdb.config.CosmosDBConfig;
import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableCosmosRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCosmosRepositories(basePackages = "com.josiasmartins.cosmos_spring.config.repository")
public class AzureCosmosDbConfiguration {

    @Value("${azure.cosmosdb.uri}")
    private String uri;

    @Value("${azure.cosmosdb.key}")
    private String key;

    @Value("${azure.cosmosdb.database}")
    private String dbName;

    private CosmosKeyCredential cosmosKeyCredential;

    @Bean
    public CosmosDBConfig getConfig() {
        this.cosmosKeyCredential = new CosmosKeyCredential(key);
        CosmosDBConfig cosmosDBConfig = CosmosDBConfig.builder(uri, this.cosmosKeyCredential, dbName)
                .build();
        return cosmosDBConfig;
    }

}
