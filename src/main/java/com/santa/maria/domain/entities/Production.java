package com.santa.maria.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "production")
public class Production {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "production_id")
  private UUID productionId;

  @Column(name = "start_date")
  private Date startDate;

  @Column(name = "end_date")
  private Date endDate;

  @Column(name = "produced_quantity_kg")
  private float producedQuantityKg;

  private String shift;

  @Column(name = "production_line")
  private String productionLine;

  @Column(name = "operator_name")
  private String operator;

  @ManyToOne
  @JoinColumn(name = "product_id")
  @JsonIgnore()
  private Product product;

  @OneToMany(mappedBy = "production", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Downtime> downtimes;

  @OneToMany(mappedBy = "production", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Waste> wastes;
}
