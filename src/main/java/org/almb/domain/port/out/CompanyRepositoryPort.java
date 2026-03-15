package org.almb.domain.port.out;

import org.almb.domain.model.Company;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyRepositoryPort {

    Flux<Company> findAll();

    Mono<Company> findByCvr(String cvr);

    Mono<Company> save(Company company);
}
