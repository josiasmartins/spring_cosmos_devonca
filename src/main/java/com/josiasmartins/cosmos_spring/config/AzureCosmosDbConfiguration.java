//package com.josiasmartins.cosmos_spring.config;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.lang.Nullable;
//
//import com.azure.core.credential.AzureKeyCredential;
//import com.azure.cosmos.CosmosClientBuilder;
//import com.azure.cosmos.DirectConnectionConfig;
//import com.azure.cosmos.GatewayConnectionConfig;
//import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
//import com.azure.spring.data.cosmos.config.CosmosConfig;
//import com.azure.spring.data.cosmos.core.ResponseDiagnostics;
//import com.azure.spring.data.cosmos.core.ResponseDiagnosticsProcessor;
//import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
//
//@Configuration
//@EnableCosmosRepositories
//@EnableConfigurationProperties(CosmosProperties.class)
//public class AzureCosmosDbConfiguration extends AbstractCosmosConfiguration  {
//
//    private static final Logger LOGGER = LogManager.getLogger(AzureCosmosDbConfiguration.class);
//
//    @Value("${azure.cosmos.uri}")
//    private String uri;
//
//    @Value("${azure.cosmos.key}")
//    private String key;
//
//    @Value("${azure.cosmos.secondaryKey}")
//    private String secondaryKey;
//
//    @Value("${azure.cosmos.database}")
//    private String dbName;
//
//    @Value("${azure.cosmos.queryMetricsEnabled}")
//    private boolean queryMetricsEnabled;
//
//    private AzureKeyCredential azureKeyCredential;
//
//    /*
//     * @Autowired private UserRepository repository;
//     */
//
//    @Bean
//    public CosmosClientBuilder getCosmosClientBuilder() {
//        this.azureKeyCredential = new AzureKeyCredential(key);
//        DirectConnectionConfig directConnectionConfig = new DirectConnectionConfig();
//        GatewayConnectionConfig gatewayConnectionConfig = new GatewayConnectionConfig();
//        return new CosmosClientBuilder()
//                .endpoint(uri)
//                .credential(azureKeyCredential)
//                .directMode(directConnectionConfig, gatewayConnectionConfig);
//    }
//
//    @Override
//    public CosmosConfig cosmosConfig() {
//        return CosmosConfig.builder()
//                .enableQueryMetrics(queryMetricsEnabled)
//                .responseDiagnosticsProcessor(new ResponseDiagnosticsProcessorImplementation())
//                .build();
//    }
//
//    public void switchToSecondaryKey() {
//        this.azureKeyCredential.update(secondaryKey);
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return this.dbName;
//    }
//
//    private static class ResponseDiagnosticsProcessorImplementation implements ResponseDiagnosticsProcessor {
//
//        @Override
//        public void processResponseDiagnostics(@Nullable ResponseDiagnostics responseDiagnostics) {
//            LOGGER.info("Response Diagnostics {}", responseDiagnostics);
//        }
//    }
//
//}