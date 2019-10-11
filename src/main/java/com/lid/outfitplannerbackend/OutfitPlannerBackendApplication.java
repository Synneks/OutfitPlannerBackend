package com.lid.outfitplannerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.lid.outfitplannerbackend.persistence")
@EntityScan(basePackages = "com.lid.outfitplanner.model")
@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class})
public class OutfitPlannerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutfitPlannerBackendApplication.class, args);
    }
}
