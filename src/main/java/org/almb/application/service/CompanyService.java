package org.almb.application.service;

import org.almb.domain.port.in.CompanyUseCase;
import org.almb.domain.port.out.CompanyRepositoryPort;
import org.almb.domain.model.Company;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyService implements CompanyUseCase {

    private final CompanyRepositoryPort repository;

    public CompanyService(CompanyRepositoryPort repository) {
        this.repository = repository;
    }

    public Flux<Company> getCompanies() {
        return repository.findAll();
    }

    public Mono<Company> getCompanyByCvr(String cvr) {
        return repository.findByCvr(cvr);
    }

    public Mono<Company> createCompany(Company company) {
        return repository.save(company);
    }

//    public Mono<Profitability> getProfitability(String cvr) {
//        return repository.findByCvr(cvr)
//                .map(Company::getProfitability);
//    }
}