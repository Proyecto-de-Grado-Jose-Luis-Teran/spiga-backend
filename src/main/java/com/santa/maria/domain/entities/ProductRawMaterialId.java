package com.santa.maria.domain.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class ProductRawMaterialId implements Serializable {
  private UUID productId;
  private UUID rawMaterialId;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    ProductRawMaterialId that = (ProductRawMaterialId) o;
    return Objects.equals(productId, that.productId) &&
            Objects.equals(rawMaterialId, that.rawMaterialId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, rawMaterialId);
  }
}
