package org.almb.adapter.mapper;

import org.almb.adapter.in.web.dto.CreateOwner;
import org.almb.adapter.in.web.dto.Owner;
import org.almb.adapter.out.persistence.entity.OwnerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerEntity toEntity(CreateOwner dto);

    Owner toDto(OwnerEntity entity);

}