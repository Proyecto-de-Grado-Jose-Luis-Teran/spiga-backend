package com.santa.maria.presentation.controllers;

import com.santa.maria.application.mappers.IWasteMapper;
import com.santa.maria.application.requests.WasteCreateRequest;
import com.santa.maria.application.requests.WasteUpdateRequest;
import com.santa.maria.application.responses.WasteResponse;
import com.santa.maria.application.services.contracts.IWasteService;
import com.santa.maria.domain.entities.Waste;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wastes")
public class WasteController {
  private final IWasteService wasteService;
  private final IWasteMapper wasteMapper;

  public WasteController(IWasteService wasteService,
                          IWasteMapper wasteMapper) {
    this.wasteService = wasteService;
    this.wasteMapper = wasteMapper;
  }

  @GetMapping("/{wasteId}")
  public ResponseEntity<WasteResponse> getWasteById(@PathVariable("wasteId") UUID wasteId) {
    Optional<Waste> waste = wasteService.getWasteById(wasteId);
    WasteResponse wasteResponse = wasteMapper.mapToResponse(waste.get());

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(wasteResponse);
  }

  @GetMapping
  public ResponseEntity<List<WasteResponse>> getAllWastes() {
    List<WasteResponse> wasteResponses =
            wasteService
                    .getAllWastes()
                    .stream()
                    .map(wasteMapper::mapToResponse)
                    .toList();

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(wasteResponses);
  }

  @PostMapping
  public ResponseEntity<WasteResponse> createWaste(
          @Valid @RequestBody WasteCreateRequest wasteCreateRequest) {
    Waste waste = wasteService.createWaste(wasteCreateRequest);
    WasteResponse wasteResponse = wasteMapper.mapToResponse(waste);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(wasteResponse);
  }

  @PutMapping("/{wasteId}")
  public ResponseEntity<WasteResponse> updateWaste(
          @PathVariable("wasteId") UUID wasteId,
          @Valid @RequestBody WasteUpdateRequest wasteUpdateRequest) {
    Waste waste = wasteService.updateWasteById(wasteId, wasteUpdateRequest);
    WasteResponse wasteResponse = wasteMapper.mapToResponse(waste);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(wasteResponse);
  }

  @DeleteMapping("/{wasteId}")
  public ResponseEntity<?> deleteWaste(@PathVariable("wasteId") UUID wasteId) {
    boolean isWasteDeleted = wasteService.deleteWasteById(wasteId);

    if (!isWasteDeleted) {
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body("Waste with id " + wasteId + " not found");
    }

    return ResponseEntity
            .status(HttpStatus.OK)
            .body("Waste deleted successfully");
  }
}
