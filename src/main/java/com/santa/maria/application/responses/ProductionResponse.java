package com.santa.maria.application.responses;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ProductionResponse(
        UUID productionId,
        Date startDate,
        Date endDate,
        float producedQuantityKg,
        String shift,
        String productionLine,
        String operator,
        List<DowntimeResponse> downtimeResponses,
        List<WasteResponse> wasteResponses
) {}
