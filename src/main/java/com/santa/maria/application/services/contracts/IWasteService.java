package com.santa.maria.application.services.contracts;

import com.santa.maria.application.requests.WasteCreateRequest;
import com.santa.maria.application.requests.WasteUpdateRequest;
import com.santa.maria.domain.entities.Waste;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IWasteService {
  Optional<Waste> getWasteById(UUID wasteId);

  List<Waste> getAllWastes();

  Waste createWaste(WasteCreateRequest wasteCreateRequest);

  Waste updateWasteById(UUID wasteId, WasteUpdateRequest wasteUpdateRequest);

  boolean deleteWasteById(UUID wasteId);
}
