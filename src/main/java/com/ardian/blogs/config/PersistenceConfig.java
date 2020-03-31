package com.ardian.blogs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
class PersistenceConfig {

    // @Bean
    // AuditorAware<String> auditorProvider() {
    //     return new AuditorAwareImpl();
    // }
}