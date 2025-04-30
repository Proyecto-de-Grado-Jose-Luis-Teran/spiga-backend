package com.santa.maria.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_raw_material")
public class ProductRawMaterial {

  @EmbeddedId
  private ProductRawMaterialId productRawMaterialId;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  @JsonIgnore()
  private Product product;

  @ManyToOne
  @MapsId("rawMaterialId")
  @JoinColumn(name = "raw_material_id")
  @JsonIgnore()
  private RawMaterial rawMaterial;

  @Column(name = "estimated_quantity_kg_per_unit")
  private float estimatedQuantityKgPerUnit;
}
