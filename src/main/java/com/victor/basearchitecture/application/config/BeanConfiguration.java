package com.victor.basearchitecture.application.config;

import com.victor.basearchitecture.domain.gateway.StoragePersonGateway;
import com.victor.basearchitecture.domain.service.CreatePersonService;
import com.victor.basearchitecture.domain.service.ListPersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    CreatePersonService createPersonService(StoragePersonGateway storagePersonGateway) {
        return new CreatePersonService(storagePersonGateway);
    }

    @Bean
    ListPersonService listPersonService(StoragePersonGateway storagePersonGateway) {
        return new ListPersonService(storagePersonGateway);
    }
}
