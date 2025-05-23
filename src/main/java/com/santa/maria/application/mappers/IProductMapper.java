package com.santa.maria.application.mappers;

import com.santa.maria.application.responses.ProductRawMaterialResponse;
import com.santa.maria.application.responses.ProductResponse;
import com.santa.maria.application.responses.ProductionResponse;
import com.santa.maria.domain.entities.Product;
import com.santa.maria.domain.entities.ProductRawMaterial;
import com.santa.maria.domain.entities.Production;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {
  IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

  ProductResponse mapToProductResponse(Product product);

  ProductRawMaterialResponse mapToProductRawMaterialResponse(ProductRawMaterial rawMaterial);
  ProductionResponse mapToProductionResponse(Production production);

  default List<ProductRawMaterialResponse> mapRawMaterials(List<ProductRawMaterial> rawMaterials) {
    return rawMaterials.stream()
            .map(this::mapToProductRawMaterialResponse)
            .toList();
  }

  default List<ProductionResponse> mapProductions(List<Production> productions) {
    return productions.stream()
            .map(this::mapToProductionResponse)
            .toList();
  }
}
