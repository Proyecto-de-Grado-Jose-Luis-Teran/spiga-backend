package com.santa.maria.application.services.concretes;

import com.santa.maria.application.mappers.IConsumptionMapper;
import com.santa.maria.application.requests.ConsumptionCreateRequest;
import com.santa.maria.application.requests.ConsumptionUpdateRequest;
import com.santa.maria.application.services.contracts.IConsumptionService;
import com.santa.maria.domain.entities.Consumption;
import com.santa.maria.domain.repositories.IConsumptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsumptionService implements IConsumptionService {
  private final IConsumptionRepository consumptionRepository;

  public ConsumptionService(IConsumptionRepository consumptionRepository) {
    this.consumptionRepository = consumptionRepository;
  }

  @Override
  public Optional<Consumption> getConsumptionById(UUID consumptionId) {
    return consumptionRepository.findById(consumptionId);
  }

  @Override
  public List<Consumption> getAllConsumptions() {
    return consumptionRepository.findAll();
  }

  @Override
  public Consumption createConsumption(ConsumptionCreateRequest consumptionCreateRequest) {
    return null;
  }

  @Override
  public Consumption updateConsumptionById(UUID consumptionId, ConsumptionUpdateRequest consumptionUpdateRequest) {
    return null;
  }

  @Override
  public boolean deleteConsumptionById(UUID consumptionId) {
    return false;
  }
}
