package com.santa.maria.presentation.controllers;

import com.santa.maria.application.mappers.IDowntimeMapper;
import com.santa.maria.application.requests.DowntimeCreateRequest;
import com.santa.maria.application.requests.DowntimeUpdateRequest;
import com.santa.maria.application.responses.DowntimeResponse;
import com.santa.maria.application.services.contracts.IDowntimeService;
import com.santa.maria.domain.entities.Downtime;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/downtimes")
public class DowntimeController {
  private final IDowntimeService downtimeService;
  private final IDowntimeMapper downtimeMapper;

  public DowntimeController(IDowntimeService downtimeService, IDowntimeMapper downtimeMapper) {
    this.downtimeService = downtimeService;
    this.downtimeMapper = downtimeMapper;
  }

  @GetMapping("/{downtimeId}")
  public ResponseEntity<DowntimeResponse> getDowntimeById(@PathVariable("downtimeId") UUID downtimeId) {
    Optional<Downtime> downtime = downtimeService.getDowntimeById(downtimeId);
    DowntimeResponse downtimeResponse = downtimeMapper.mapToResponse(downtime.get());

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(downtimeResponse);
  }

  @GetMapping
  public ResponseEntity<List<DowntimeResponse>> getAllDowntimes() {
    List<DowntimeResponse> downtimeResponses =
            downtimeService
                    .getAllDowntimes()
                    .stream()
                    .map(downtimeMapper::mapToResponse)
                    .toList();

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(downtimeResponses);
  }

  @PostMapping
  public ResponseEntity<DowntimeResponse> createDowntime(
          @Valid @RequestBody DowntimeCreateRequest downtimeCreateRequest) {
    Downtime downtime = downtimeService.createDowntime(downtimeCreateRequest);
    DowntimeResponse downtimeResponse = downtimeMapper.mapToResponse(downtime);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(downtimeResponse);
  }

  @PutMapping("/{downtimeId}")
  public ResponseEntity<DowntimeResponse> updateDowntime(
          @PathVariable("downtimeId") UUID downtimeId,
          @Valid @RequestBody DowntimeUpdateRequest downtimeUpdateRequest) {
    Downtime downtime = downtimeService.updateDowntimeById(downtimeId, downtimeUpdateRequest);
    DowntimeResponse downtimeResponse = downtimeMapper.mapToResponse(downtime);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(downtimeResponse);
  }

  @DeleteMapping("/{downtimeId}")
  public ResponseEntity<?> deleteDowntime(@PathVariable("downtimeId") UUID downtimeId) {
    boolean isDowntimeDeleted = downtimeService.deleteDowntimeById(downtimeId);

    if (!isDowntimeDeleted) {
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body("Downtime with id " + downtimeId + " not found");
    }

    return ResponseEntity
            .status(HttpStatus.OK)
            .body("Downtime deleted successfully");
  }
}
