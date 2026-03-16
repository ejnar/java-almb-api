package org.almb.application.service;

import org.almb.domain.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;


@SpringBootTest
class CompanyServiceH2Test {

    Company company;
    @Autowired
    private CompanyService service;

    @BeforeEach
    void setup() {
        company = new Company();
        company.setCvr("12345678");
        company.setPhoneNumber("1234567890");
    }

    @Test
    void shouldCreateCompany() {
        StepVerifier.create(service.createCompany(company))
                .expectNextMatches(c -> c.getCvr().equals("12345678"))
                .verifyComplete();
    }

}