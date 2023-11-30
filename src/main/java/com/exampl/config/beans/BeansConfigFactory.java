package com.exampl.config.beans;

import com.exampl.config.properties.PropConfiguration;
import com.github.javafaker.Faker;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.aeonbits.owner.ConfigFactory;

@Factory
public class BeansConfigFactory {
    private final PropConfiguration propConfiguration = ConfigFactory.create(PropConfiguration.class);

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public PropConfiguration propConfiguration() {
        return propConfiguration;
    }
}
