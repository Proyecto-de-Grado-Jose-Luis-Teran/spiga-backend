package com.santa.maria.application.services.contracts;

import com.santa.maria.application.requests.DowntimeCreateRequest;
import com.santa.maria.application.requests.DowntimeUpdateRequest;
import com.santa.maria.domain.entities.Downtime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDowntimeService {
  Optional<Downtime> getDowntimeById(UUID downtimeId);

  List<Downtime> getAllDowntimes();

  Downtime createDowntime(DowntimeCreateRequest downtimeCreateRequest);

  Downtime updateDowntimeById(UUID downtimeId, DowntimeUpdateRequest downtimeUpdateRequest);

  boolean deleteDowntimeById(UUID downtimeId);
}
