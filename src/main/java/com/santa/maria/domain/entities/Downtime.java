package com.santa.maria.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "downtime")
public class Downtime {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "downtime_id")
  private UUID downtimeId;

  @Column(name = "start_datetime")
  private Date startDateTime;

  @Column(name = "end_datetime")
  private Date endDateTime;

  @Column(name = "downtime_type")
  private String downtimeType;
  private String reason;
  private String machine;

  @ManyToOne
  @JoinColumn(name = "production_id")
  @JsonIgnore()
  private Production production;
}
