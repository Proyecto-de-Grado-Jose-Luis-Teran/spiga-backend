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
@Table(name = "raw_material_consumption")
public class Consumption {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "consumption_id")
  private UUID consumptionId;

  @Column(name = "used_bags_quantity")
  private int usedBagsQuantity;

  @Column(name = "total_kg")
  private float totalKg;

  @ManyToOne
  @JoinColumn(name = "production_id")
  @JsonIgnore()
  private Production production;

  @ManyToOne
  @JoinColumn(name = "raw_material_id")
  @JsonIgnore()
  private RawMaterial rawMaterial;
}
