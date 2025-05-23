package com.santa.maria.application.services.concretes;

import com.santa.maria.application.mappers.IRawMaterialMapper;
import com.santa.maria.application.requests.RawMaterialCreateRequest;
import com.santa.maria.application.requests.RawMaterialUpdateRequest;
import com.santa.maria.application.responses.RawMaterialResponse;
import com.santa.maria.application.services.contracts.IRawMaterialService;
import com.santa.maria.domain.entities.RawMaterial;
import com.santa.maria.domain.repositories.IRawMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RawMaterialService implements IRawMaterialService {
  private final IRawMaterialRepository rawMaterialRepository;

  public RawMaterialService(IRawMaterialRepository rawMaterialRepository) {
    this.rawMaterialRepository = rawMaterialRepository;
  }

  @Override
  public Optional<RawMaterial> getRawMaterialById(UUID rawMaterialId) {
    return rawMaterialRepository.findById(rawMaterialId);
  }

  @Override
  public List<RawMaterial> getAllRawMaterials() {
    return rawMaterialRepository.findAll();
  }

  @Override
  public RawMaterial createRawMaterial(RawMaterialCreateRequest rawMaterialCreateRequest) {
    return null;
  }

  @Override
  public RawMaterial updateRawMaterialById(UUID rawMaterialId, RawMaterialUpdateRequest rawMaterialUpdateRequest) {
    return null;
  }

  @Override
  public boolean deleteRawMaterialById(UUID rawMaterialId) {
    return false;
  }
}
