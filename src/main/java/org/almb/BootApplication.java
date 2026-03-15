package org.almb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


// @EnableJpaRepositories("org.almb.adapter.out.persistence.repository")
@SpringBootApplication
@EntityScan("org.almb.adapter.out.persistence.entity")
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);

    }
}
