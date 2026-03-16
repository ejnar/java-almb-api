package org.almb.adapter.out.persistence.mapper;

import org.almb.adapter.out.persistence.entity.CompanyEntity;
import org.almb.domain.model.Address;
import org.almb.domain.model.Company;
import org.almb.domain.model.Profitability;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toDomain(CompanyEntity company);

    @AfterMapping
    default void enrich(@MappingTarget Company company, CompanyEntity entity) {
        Address adress = new Address();
        adress.setCity(entity.getCity());
        adress.setStreet(entity.getStreet());
        adress.setPostalCode(entity.getPostalCode());
        adress.setCountry(entity.getCountry());
        company.setAddress(adress);

        Profitability profitability = new Profitability();
        profitability.setNetProfit(entity.getNetProfit());
        profitability.setExpenses(entity.getExpenses());
        profitability.setRevenue(entity.getRevenue());
        company.setProfitability(profitability);
    }

    CompanyEntity toEntity(Company company);

    @AfterMapping
    default void enrich(@MappingTarget CompanyEntity entity, Company company) {

        if (company.getAddress() != null) {
            entity.setCity(company.getAddress().getCity());
            entity.setStreet(company.getAddress().getStreet());
            entity.setPostalCode(company.getAddress().getPostalCode());
            entity.setCountry(company.getAddress().getCountry());
        }
        if (company.getProfitability() != null) {
            entity.setNetProfit(company.getProfitability().getNetProfit());
            entity.setExpenses(company.getProfitability().getExpenses());
            entity.setRevenue(company.getProfitability().getRevenue());
        }
    }

}