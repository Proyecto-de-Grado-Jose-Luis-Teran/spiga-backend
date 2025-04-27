package com.santa.maria.application.responses;

import java.util.UUID;

public record ProductResponse(
        UUID productId,
        String name,
        String productionUnit
) {}
