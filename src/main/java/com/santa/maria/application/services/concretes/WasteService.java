package com.santa.maria.application.services.concretes;

import com.santa.maria.application.requests.WasteCreateRequest;
import com.santa.maria.application.requests.WasteUpdateRequest;
import com.santa.maria.application.services.contracts.IWasteService;
import com.santa.maria.domain.entities.Production;
import com.santa.maria.domain.entities.Waste;
import com.santa.maria.domain.repositories.IProductionRepository;
import com.santa.maria.domain.repositories.IWasteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WasteService implements IWasteService {
  private final IWasteRepository wasteRepository;
  private final IProductionRepository productionRepository;

  public WasteService(IWasteRepository wasteRepository,
                      IProductionRepository productionRepository) {
    this.wasteRepository = wasteRepository;
    this.productionRepository = productionRepository;
  }

  @Override
  public Optional<Waste> getWasteById(UUID wasteId) {
    return wasteRepository.findById(wasteId);
  }

  @Override
  public List<Waste> getAllWastes() {
    return wasteRepository.findAll();
  }

  @Override
  public Waste createWaste(WasteCreateRequest wasteCreateRequest) {
    Waste waste = new Waste();
    waste.setQuantityKg(wasteCreateRequest.quantityKg());
    waste.setReason(wasteCreateRequest.reason());

    if (wasteCreateRequest.productionId() != null) {
      Production production = productionRepository.findById(wasteCreateRequest.productionId())
              .orElseThrow(() -> new RuntimeException("Production not found"));
      waste.setProduction(production);
    }

    Waste savedWaste = wasteRepository.save(waste);
    return savedWaste;
  }

  @Override
  public Waste updateWasteById(UUID wasteId, WasteUpdateRequest wasteUpdateRequest) {
    Waste waste = wasteRepository.findById(wasteId)
            .orElseThrow(() -> new RuntimeException("Waste not found"));

    waste.setQuantityKg(wasteUpdateRequest.quantityKg());
    waste.setReason(wasteUpdateRequest.reason());

    if (wasteUpdateRequest.productionId() != null) {
      Production production = productionRepository.findById(wasteUpdateRequest.productionId())
              .orElseThrow(() -> new RuntimeException("Production not found"));
      waste.setProduction(production);
    } else {
      waste.setProduction(null);
    }

    Waste updatedWaste = wasteRepository.save(waste);
    return updatedWaste;
  }

  @Override
  public boolean deleteWasteById(UUID wasteId) {
    return wasteRepository.findById(wasteId)
            .map(waste -> {
              wasteRepository.delete(waste);
              return true;
            })
            .orElse(false);
  }
}
