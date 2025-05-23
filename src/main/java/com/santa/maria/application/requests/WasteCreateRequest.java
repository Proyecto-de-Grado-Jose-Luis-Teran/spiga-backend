package com.santa.maria.application.requests;

import java.util.UUID;

public record WasteCreateRequest(
        float quantityKg,
        String reason,
        UUID productionId
) { }
