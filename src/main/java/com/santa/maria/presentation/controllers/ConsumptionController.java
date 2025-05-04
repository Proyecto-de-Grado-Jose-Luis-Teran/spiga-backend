package com.santa.maria.presentation.controllers;

import com.santa.maria.application.services.contracts.IConsumptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/consumptions")
public class ConsumptionController {
  private final IConsumptionService consumptionService;

  public ConsumptionController(IConsumptionService consumptionService) {
    this.consumptionService = consumptionService;
  }

  @GetMapping("/{consumptionId}")
  public ResponseEntity<?> getConsumptionById(@PathVariable("consumptionId") UUID consumptionId) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(consumptionService.getConsumptionById(consumptionId));
  }

  @GetMapping
  public ResponseEntity<?> getAllConsumptions() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(consumptionService.getAllConsumptions());
  }
}
