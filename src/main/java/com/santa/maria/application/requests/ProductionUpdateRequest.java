package com.santa.maria.application.requests;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ProductionUpdateRequest(
        Date startDate,
        Date endDate,
        float producedQuantityKg,
        String shift,
        String productionLine,
        String operator,
        UUID productId,
        List<DowntimeCreateRequest> downtimes,
        List<WasteCreateRequest> wastes
) { }
