package com.santa.maria.application.responses;

import java.util.List;
import java.util.UUID;

public record ProductResponse(
        UUID productId,
        String name,
        String productionUnit,
        List<ProductRawMaterialResponse> productRawMaterialResponses,
        List<ProductionResponse> productionResponses
) {}
