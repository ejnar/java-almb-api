package org.almb.application.service;


import org.almb.domain.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.test.StepVerifier;

@Testcontainers
@SpringBootTest
class CompanyIntegrationTest {

    @Autowired
    CompanyService service;

    @Container
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:15");


    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.r2dbc.url",
                () -> "r2dbc:postgresql://"
                        + postgres.getHost()
                        + ":" + postgres.getFirstMappedPort()
                        + "/"
                        + postgres.getDatabaseName());

        registry.add("spring.r2dbc.username", postgres::getUsername);
        registry.add("spring.r2dbc.password", postgres::getPassword);
    }

    @Test
    void shouldCreateCompany() {

        Company company = new Company();
        company.setCvr("12345678");

        StepVerifier.create(service.createCompany(company))
                .expectNextMatches(c -> c.getCvr().equals("12345678"))
                .verifyComplete();
    }
}