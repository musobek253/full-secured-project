package com.xa.fullsecuredproject;

import com.xa.fullsecuredproject.properties.OpenAPIProperties;
import com.xa.fullsecuredproject.properties.ServiceProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@OpenAPIDefinition
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({OpenAPIProperties.class, ServiceProperties.class})
public class FullSecuredProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullSecuredProjectApplication.class, args);
    }

}
