package com.santa.maria.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "waste")
public class Waste {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "waste_id")
  private UUID wasteId;

  @Column(name = "quantity_kg")
  private float quantityKg;

  @Column(name = "reason")
  private String reason;

  @ManyToOne
  @JoinColumn(name = "production_id")
  @JsonIgnore()
  private Production production;
}
