package com.santa.maria.domain.entities;

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
@Table
@Entity(name = "raw_material")
public class RawMaterial {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "raw_material_id")
  private UUID rawMaterialId;

  private String name;

  @Column(name = "weight_per_bag_kg")
  private float weightPerBagKg;

  @OneToMany(mappedBy = "rawMaterial", cascade = CascadeType.ALL)
  private List<ProductRawMaterial> productRawMaterials;

  @OneToMany(mappedBy = "rawMaterial", cascade = CascadeType.ALL)
  private List<Consumption> consumptions;
}
