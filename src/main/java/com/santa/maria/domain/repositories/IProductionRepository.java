package com.santa.maria.domain.repositories;

import com.santa.maria.domain.entities.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProductionRepository extends JpaRepository<Production, UUID> {
}
