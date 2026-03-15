package org.almb.domain.port.in;

import org.almb.domain.model.Company;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyUseCase {

    Flux<Company> getCompanies();

    Mono<Company> getCompanyByCvr(String cvr);

    Mono<Company> createCompany(Company company);

    // Mono<Profitability> getProfitability(String cvr);
}