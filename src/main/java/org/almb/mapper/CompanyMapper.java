package org.almb.mapper;

import org.almb.adapter.in.web.dto.Company;
import org.almb.adapter.in.web.dto.CreateCompany;
import org.almb.adapter.in.web.dto.Profitability;
import org.almb.adapter.out.persistence.entity.CompanyEntity;
import org.almb.adapter.out.persistence.entity.ProfitabilityEmbeddable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyEntity toEntity(CreateCompany dto);

    Company toDto(CompanyEntity entity);

    Profitability toProfitabilityDto(ProfitabilityEmbeddable entity);

}