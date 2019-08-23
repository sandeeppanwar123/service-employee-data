package com.daffodil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class ServiceEmployeeDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceEmployeeDataApplication.class, args);
    }

}
