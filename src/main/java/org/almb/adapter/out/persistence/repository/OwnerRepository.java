package org.almb.adapter.out.persistence.repository;

import org.almb.adapter.out.persistence.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
}