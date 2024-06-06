package com.octaviookumu.employeeservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    // Making it a Bean makes it an injected object
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
