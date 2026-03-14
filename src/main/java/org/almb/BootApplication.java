package org.almb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("org.almb.adapter.out.persistence")
@EnableJpaRepositories("org.almb.adapter.out.persistence.repository")
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);

    }
}
