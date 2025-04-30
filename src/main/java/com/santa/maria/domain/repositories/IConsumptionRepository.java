package com.santa.maria.domain.repositories;

import com.santa.maria.domain.entities.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IConsumptionRepository extends JpaRepository<Consumption, UUID> {
}
