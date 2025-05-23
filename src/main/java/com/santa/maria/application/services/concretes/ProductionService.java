package com.santa.maria.application.services.concretes;

import com.santa.maria.application.requests.ProductionCreateRequest;
import com.santa.maria.application.requests.ProductionUpdateRequest;
import com.santa.maria.application.services.contracts.IProductionService;
import com.santa.maria.domain.entities.Production;
import com.santa.maria.domain.repositories.IProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductionService implements IProductionService {
  private final IProductionRepository productionRepository;

  public ProductionService(IProductionRepository productionRepository) {
    this.productionRepository = productionRepository;
  }

  @Override
  public Optional<Production> getProductionById(UUID productionId) {
    return productionRepository.findById(productionId);
  }

  @Override
  public List<Production> getAllProductions() {
    return productionRepository.findAll();
  }

  @Override
  public Production createProduction(ProductionCreateRequest productionCreateRequest) {
    return null;
  }

  @Override
  public Production updateProductionById(UUID productionId, ProductionUpdateRequest productionUpdateRequest) {
    return null;
  }

  @Override
  public boolean deleteProductionById(UUID productionId) {
    return false;
  }
}
