package com.santa.maria.application.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ProductUpdateRequest(
        @NotBlank(message = "Product name is required")
        @Size(max = 25, message = "Product name must be less than 25 characters")
        String name,

        @NotBlank(message = "Production unit is required")
        @Size(max = 30, message = "Production unit must be less than 30 characters")
        String productionUnit,

        List<ProductRawMaterialCreateRequest> productRawMaterials,
        List<ProductionCreateRequest> productions
) { }
