package com.santa.maria.application.responses;

import java.util.UUID;

public record ConsumptionResponse(
        UUID consumptionId,
        int usedBagsQuantity,
        float totalKg
) {}
