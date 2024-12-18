package com.simsimbookstore.accountserver;

import com.simsimbookstore.accountserver.properties.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
@EnableDiscoveryClient
public class AccountServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServerApplication.class, args);
    }

}
