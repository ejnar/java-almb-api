package org.almb.adapter.out.persistence.mapper;

import org.almb.adapter.out.persistence.entity.CompanyEntity;
import org.almb.domain.model.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toDomain(CompanyEntity company);

    CompanyEntity toEntity(Company company);

}