package com.santa.maria.application.services.contracts;

import com.santa.maria.application.requests.ConsumptionCreateRequest;
import com.santa.maria.application.requests.ConsumptionUpdateRequest;
import com.santa.maria.domain.entities.Consumption;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IConsumptionService {
  Optional<Consumption> getConsumptionById(UUID consumptionId);

  List<Consumption> getAllConsumptions();

  Consumption createConsumption(ConsumptionCreateRequest consumptionCreateRequest);

  Consumption updateConsumptionById(UUID consumptionId, ConsumptionUpdateRequest consumptionUpdateRequest);

  boolean deleteConsumptionById(UUID consumptionId);
}
