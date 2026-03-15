package org.almb.adapter.in.web.controller;


import org.almb.adapter.in.web.dto.Company;
import org.almb.adapter.in.web.dto.CreateCompany;
import org.almb.adapter.in.web.dto.Profitability;
import org.almb.application.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController implements org.almb.adapter.in.web.controller.CompaniesApi {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(service.getCompanies());
    }

    @Override
    public ResponseEntity<Company> createCompany(CreateCompany createCompany) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createCompany(createCompany));
    }

    @Override
    public ResponseEntity<Company> getCompanyByCvr(String cvr) {
        return ResponseEntity.ok(service.getCompanyByCvr(cvr));
    }

    @Override
    public ResponseEntity<Profitability> getCompanyProfitabilityByCvr(String cvr) {
        return ResponseEntity.ok(service.getProfitability(cvr));
    }

}