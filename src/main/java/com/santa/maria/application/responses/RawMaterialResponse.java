package com.santa.maria.application.responses;

import java.util.List;
import java.util.UUID;

public record RawMaterialResponse(
        UUID rawMaterialId,
        String name,
        float weightPerBagKg,
        List<ProductRawMaterialResponse> productRawMaterialResponses,
        List<ConsumptionResponse> consumptionResponses
) {}
