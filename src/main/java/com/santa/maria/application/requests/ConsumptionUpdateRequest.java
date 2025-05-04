package com.santa.maria.application.requests;

import java.util.UUID;

public record ConsumptionUpdateRequest(
        int usedBagsQuantity,
        float totalKg,
        UUID productionId,
        UUID rawMaterialId
) { }
