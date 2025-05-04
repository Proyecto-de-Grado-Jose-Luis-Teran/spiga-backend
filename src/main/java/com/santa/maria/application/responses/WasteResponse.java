package com.santa.maria.application.responses;

import java.util.UUID;

public record WasteResponse(
        UUID wasteId,
        float quantityKg,
        String reason,
        UUID productionId
) { }
