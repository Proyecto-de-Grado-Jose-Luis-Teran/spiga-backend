package com.santa.maria.application.requests;

import java.util.UUID;

public record WasteUpdateRequest(
        float quantityKg,
        String reason,
        UUID productionId
) { }
