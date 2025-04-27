package com.santa.maria.application.services.contracts;

import com.santa.maria.application.requests.ProductCreateRequest;
import com.santa.maria.application.requests.ProductUpdateRequest;
import com.santa.maria.application.responses.ProductResponse;
import com.santa.maria.domain.entities.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductService {
  Optional<Product> getProductById(UUID productId);

  List<Product> findAllProducts();

  ProductResponse createProduct(ProductCreateRequest productCreateRequest);

  ProductResponse updateProductById(UUID productId, ProductUpdateRequest productUpdateRequest);

  boolean deleteProductById(UUID productId);
}
