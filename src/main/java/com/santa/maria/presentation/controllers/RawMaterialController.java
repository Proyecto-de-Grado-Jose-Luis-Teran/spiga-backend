package com.santa.maria.presentation.controllers;

import com.santa.maria.application.services.contracts.IRawMaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/raw-materials")
public class RawMaterialController {
  private final IRawMaterialService rawMaterialService;

  public RawMaterialController(IRawMaterialService rawMaterialService) {
    this.rawMaterialService = rawMaterialService;
  }

  @GetMapping("/{rawMaterialId}")
  public ResponseEntity<?> getRawMaterialById(@PathVariable("rawMaterialId") UUID rawMaterialId) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(rawMaterialService.getRawMaterialById(rawMaterialId));
  }

  @GetMapping
  public ResponseEntity<?> getAllRawMaterials() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(rawMaterialService.getAllRawMaterials());
  }
}
