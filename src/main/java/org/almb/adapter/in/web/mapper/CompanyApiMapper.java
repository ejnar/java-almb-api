package org.almb.adapter.in.web.mapper;

import org.almb.domain.model.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyApiMapper {

    Company toDomain(org.almb.adapter.in.web.dto.Company company);

    org.almb.adapter.in.web.dto.Company toApi(Company company);

}