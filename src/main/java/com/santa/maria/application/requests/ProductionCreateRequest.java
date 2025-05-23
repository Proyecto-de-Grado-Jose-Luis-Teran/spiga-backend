package com.santa.maria.application.requests;

import java.util.Date;
import java.util.List;

public record ProductionCreateRequest(
        Date startDate,
        Date endDate,
        float producedQuantityKg,
        String shift,
        String productionLine,
        String operator,
        List<DowntimeCreateRequest> downtimes,
        List<WasteCreateRequest> wastes
) { }
