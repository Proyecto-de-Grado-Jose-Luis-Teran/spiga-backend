package com.santa.maria.application.responses;

import java.util.Date;
import java.util.UUID;

public record DowntimeResponse(
        UUID downtimeId,
        Date startDateTime,
        Date endDateTime,
        String downtimeType,
        String reason,
        String machine,
        UUID productionId
) { }
