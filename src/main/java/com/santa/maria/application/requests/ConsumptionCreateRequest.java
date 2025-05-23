package com.santa.maria.application.requests;

public record ConsumptionCreateRequest(
        int usedBagsQuantity,
        float totalKg
) { }
