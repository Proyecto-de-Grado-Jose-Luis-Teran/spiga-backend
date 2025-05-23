package com.santa.maria.application.services.concretes;

import com.santa.maria.application.requests.DowntimeCreateRequest;
import com.santa.maria.application.requests.DowntimeUpdateRequest;
import com.santa.maria.application.services.contracts.IDowntimeService;
import com.santa.maria.domain.entities.Downtime;
import com.santa.maria.domain.entities.Production;
import com.santa.maria.domain.repositories.IDowntimeRepository;
import com.santa.maria.domain.repositories.IProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DowntimeService implements IDowntimeService {
  private final IDowntimeRepository downtimeRepository;
  private final IProductionRepository productionRepository;

  public DowntimeService(IDowntimeRepository downtimeRepository,
                          IProductionRepository productionRepository) {
    this.downtimeRepository = downtimeRepository;
    this.productionRepository = productionRepository;
  }

  @Override
  public Optional<Downtime> getDowntimeById(UUID downtimeId) {
    return downtimeRepository.findById(downtimeId);
  }

  @Override
  public List<Downtime> getAllDowntimes() {
    return downtimeRepository.findAll();
  }

  @Override
  public Downtime createDowntime(DowntimeCreateRequest downtimeCreateRequest) {
    Downtime downtime = new Downtime();
    downtime.setStartDateTime(downtimeCreateRequest.startDateTime());
    downtime.setEndDateTime(downtimeCreateRequest.endDateTime());
    downtime.setDowntimeType(downtimeCreateRequest.downtimeType());
    downtime.setReason(downtimeCreateRequest.reason());
    downtime.setMachine(downtimeCreateRequest.machine());

    if (downtimeCreateRequest.productionId() != null) {
      Production production = productionRepository.findById(downtimeCreateRequest.productionId())
              .orElseThrow(() -> new RuntimeException("Production not found"));
      downtime.setProduction(production);
    }

    Downtime savedDowntime = downtimeRepository.save(downtime);
    return savedDowntime;
  }

  @Override
  public Downtime updateDowntimeById(UUID downtimeId, DowntimeUpdateRequest downtimeUpdateRequest) {
    Downtime downtime = downtimeRepository.findById(downtimeId)
            .orElseThrow(() -> new RuntimeException("Downtime not found"));

    downtime.setStartDateTime(downtimeUpdateRequest.startDateTime());
    downtime.setEndDateTime(downtimeUpdateRequest.endDateTime());
    downtime.setDowntimeType(downtimeUpdateRequest.downtimeType());
    downtime.setReason(downtimeUpdateRequest.reason());
    downtime.setMachine(downtimeUpdateRequest.machine());

    if (downtimeUpdateRequest.productionId() != null) {
      Production production = productionRepository.findById(downtimeUpdateRequest.productionId())
              .orElseThrow(() -> new RuntimeException("Production not found"));
      downtime.setProduction(production);
    } else {
      downtime.setProduction(null);
    }

    Downtime updatedDowntime = downtimeRepository.save(downtime);
    return updatedDowntime;
  }

  @Override
  public boolean deleteDowntimeById(UUID downtimeId) {
    return downtimeRepository.findById(downtimeId)
            .map(downtime -> {
              downtimeRepository.delete(downtime);
              return true;
            })
            .orElse(false);
  }
}
