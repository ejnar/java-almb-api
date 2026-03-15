package org.almb.adapter.in.web.controller;

import org.almb.adapter.in.web.dto.Company;
import org.almb.adapter.in.web.mapper.CompanyApiMapper;
import org.almb.domain.port.in.CompanyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyUseCase service;
    private final CompanyApiMapper mapper;

    public CompanyController(CompanyUseCase service, CompanyApiMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public Flux<Company> getCompanies() {
        return service.getCompanies().map(mapper::toApi);
    }

    @GetMapping("/{cvr}")
    public Mono<Company> getCompany(@PathVariable String cvr) {
        return service.getCompanyByCvr(cvr).map(mapper::toApi);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<org.almb.adapter.in.web.dto.Company> createCompany(@RequestBody Company company) {
        return service.createCompany(mapper.toDomain(company)).map(mapper::toApi);
    }

  /*  @GetMapping("/{cvr}/profitability")
    public Mono<org.almb.adapter.in.web.dto.Profitability> profitability(@PathVariable String cvr) {
        return service.getProfitability(cvr);
    }*/
}