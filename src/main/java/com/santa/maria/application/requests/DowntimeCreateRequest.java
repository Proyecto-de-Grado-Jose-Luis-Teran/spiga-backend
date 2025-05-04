package com.santa.maria.application.requests;

import java.util.Date;
import java.util.UUID;

public record DowntimeCreateRequest(
        Date startDateTime,
        Date endDateTime,
        String downtimeType,
        String reason,
        String machine,
        UUID productionId
) { }
