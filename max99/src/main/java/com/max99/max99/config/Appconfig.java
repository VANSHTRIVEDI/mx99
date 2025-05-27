package com.max99.max99.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
    @Bean
    ModelMapper getModelMapper() {

        return new ModelMapper();
    }
}
