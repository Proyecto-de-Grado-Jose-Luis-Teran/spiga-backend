package com.santa.maria.application.services.contracts;

import com.santa.maria.application.requests.ProductCreateRequest;
import com.santa.maria.application.requests.ProductUpdateRequest;
import com.santa.maria.domain.entities.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductService {
  Optional<Product> getProductById(UUID productId);

  List<Product> getAllProducts();

  Product createProduct(ProductCreateRequest productCreateRequest);

  Product updateProductById(UUID productId, ProductUpdateRequest productUpdateRequest);

  boolean deleteProductById(UUID productId);
}
