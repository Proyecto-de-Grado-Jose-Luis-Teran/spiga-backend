package com.santa.maria.application.mappers;

import com.santa.maria.application.responses.ProductResponse;
import com.santa.maria.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IProductMapper {
  IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

  Product mapToProduct(ProductResponse productResponse);

  ProductResponse mapToProductResponse(Product product);
}
