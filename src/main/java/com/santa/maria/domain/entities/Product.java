package com.santa.maria.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "product_id", updatable = false, nullable = false)
  private UUID productId;

  @Column(name = "name")
  private String name;

  @Column(name = "production_unit")
  private String productionUnit;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private List<ProductRawMaterial> rawMaterials;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  @JsonIgnore()
  private List<Production> productions;
}
