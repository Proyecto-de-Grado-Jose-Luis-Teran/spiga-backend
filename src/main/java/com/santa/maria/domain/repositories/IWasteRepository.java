package com.santa.maria.domain.repositories;

import com.santa.maria.domain.entities.Waste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IWasteRepository extends JpaRepository<Waste, UUID> {
}
