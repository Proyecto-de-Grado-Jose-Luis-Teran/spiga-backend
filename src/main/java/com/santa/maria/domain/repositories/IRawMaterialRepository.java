package com.santa.maria.domain.repositories;

import com.santa.maria.domain.entities.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRawMaterialRepository extends JpaRepository<RawMaterial, UUID> {
}
