package com.santa.maria.application.services.contracts;

import com.santa.maria.application.requests.ProductionCreateRequest;
import com.santa.maria.application.requests.ProductionUpdateRequest;
import com.santa.maria.domain.entities.Production;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductionService {
  Optional<Production> getProductionById(UUID productionId);

  List<Production> getAllProductions();

  Production createProduction(ProductionCreateRequest productionCreateRequest);

  Production updateProductionById(UUID productionId, ProductionUpdateRequest productionUpdateRequest);

  boolean deleteProductionById(UUID productionId);
}
