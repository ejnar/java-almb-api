package org.almb.adapter.out.persistence.repository;

import org.almb.adapter.out.persistence.entity.CompanyEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface R2dbcCompanyRepository
        extends ReactiveCrudRepository<CompanyEntity, Long> {

    Mono<CompanyEntity> findByCvr(String cvr);
}
