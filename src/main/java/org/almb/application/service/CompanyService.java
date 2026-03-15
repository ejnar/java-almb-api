package org.almb.application.service;

import org.almb.adapter.in.web.dto.Company;
import org.almb.adapter.in.web.dto.CreateCompany;
import org.almb.adapter.in.web.dto.Profitability;
import org.almb.adapter.out.persistence.entity.CompanyEntity;
import org.almb.adapter.out.persistence.repository.CompanyRepository;
import org.almb.adapter.mapper.CompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyService {

    private static final Logger log = LoggerFactory.getLogger(CompanyService.class);

    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    public CompanyService(CompanyRepository repository, CompanyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Company> getCompanies() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Company createCompany(CreateCompany request) {
        CompanyEntity entity = mapper.toEntity(request);
        repository.save(entity);
        log.debug("Saved: {}", entity);
        return mapper.toDto(entity);
    }

    public Company getCompanyByCvr(String cvr) {
        CompanyEntity entity =
                repository.findByCvr(cvr)
                        .orElseThrow();
        return mapper.toDto(entity);
    }

    public Profitability getProfitability(String cvr) {
        CompanyEntity entity = repository.findByCvr(cvr)
                .orElseThrow();
        return mapper.toProfitabilityDto(entity.getProfitability());
    }
}