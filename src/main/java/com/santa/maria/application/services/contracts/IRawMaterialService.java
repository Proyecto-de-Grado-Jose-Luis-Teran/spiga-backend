package com.santa.maria.application.services.contracts;

import com.santa.maria.application.requests.RawMaterialCreateRequest;
import com.santa.maria.application.requests.RawMaterialUpdateRequest;
import com.santa.maria.domain.entities.RawMaterial;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRawMaterialService {
  Optional<RawMaterial> getRawMaterialById(UUID rawMaterialId);

  List<RawMaterial> getAllRawMaterials();

  RawMaterial createRawMaterial(RawMaterialCreateRequest rawMaterialCreateRequest);

  RawMaterial updateRawMaterialById(UUID rawMaterialId, RawMaterialUpdateRequest rawMaterialUpdateRequest);

  boolean deleteRawMaterialById(UUID rawMaterialId);
}
