package org.almb.adapter.out.persistence;

import org.almb.adapter.out.persistence.mapper.CompanyMapper;
import org.almb.adapter.out.persistence.repository.R2dbcCompanyRepository;
import org.almb.domain.model.Company;
import org.almb.domain.port.out.CompanyRepositoryPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CompanyPersistenceAdapter implements CompanyRepositoryPort {

    private final R2dbcCompanyRepository repository;
    private final CompanyMapper mapper;

    public CompanyPersistenceAdapter(
            R2dbcCompanyRepository repository,
            CompanyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<Company> findAll() {
        return repository.findAll()
                .map(mapper::toDomain);
    }

    public Mono<Company> findByCvr(String cvr) {
        return repository.findByCvr(cvr)
                .map(mapper::toDomain);
    }

    public Mono<Company> save(Company company) {
        return repository.save(mapper.toEntity(company))
                .map(mapper::toDomain);
    }
}
