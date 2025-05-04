package com.santa.maria.presentation.controllers;

import com.santa.maria.application.services.contracts.IProductionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/productions")
public class ProductionController {
  private final IProductionService productionService;

  public ProductionController(IProductionService productionService) {
    this.productionService = productionService;
  }

  @GetMapping("/{productionId}")
  public ResponseEntity<?> getProductionById(@PathVariable("productionId") UUID productionId) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productionService.getProductionById(productionId));
  }

  @GetMapping
  public ResponseEntity<?> getAllProductions() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productionService.getAllProductions());
  }
}
