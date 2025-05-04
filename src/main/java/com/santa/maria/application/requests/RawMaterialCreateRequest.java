package com.santa.maria.application.requests;

import java.util.List;

public record RawMaterialCreateRequest(
        String name,
        float weightPerBagKg,
        List<ProductRawMaterialCreateRequest> productRawMaterials,
        List<ConsumptionCreateRequest> consumptions
) { }
