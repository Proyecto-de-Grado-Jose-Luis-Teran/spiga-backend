package com.santa.maria.application.services.concretes;

import com.santa.maria.application.mappers.IProductMapper;
import com.santa.maria.application.requests.ProductCreateRequest;
import com.santa.maria.application.requests.ProductUpdateRequest;
import com.santa.maria.application.responses.ProductResponse;
import com.santa.maria.application.services.contracts.IProductService;
import com.santa.maria.domain.entities.Product;
import com.santa.maria.domain.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
  private final IProductRepository productRepository;
  private final IProductMapper productMapper;

  public ProductService(IProductRepository productRepository, IProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  @Override
  public Optional<Product> getProductById(UUID productId) {
    return productRepository.findById(productId);
  }

  @Override
  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public ProductResponse createProduct(ProductCreateRequest productCreateRequest) {
    Product product = new Product();
    product.setName(productCreateRequest.name());
    product.setProductionUnit(productCreateRequest.productionUnit());

    productRepository.save(product);

    return productMapper.mapToProductResponse(product);
  }

  @Override
  public ProductResponse updateProductById(UUID productId, ProductUpdateRequest productUpdateRequest) {
    Product existingProduct = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

    existingProduct.setName(productUpdateRequest.name());
    existingProduct.setProductionUnit(productUpdateRequest.productionUnit());

    Product updatedProduct = productRepository.save(existingProduct);

    return productMapper.mapToProductResponse(updatedProduct);
  }

  @Override
  public boolean deleteProductById(UUID productId) {
    return productRepository.findById(productId)
            .map(product -> {
              productRepository.delete(product);
              return true;
            })
            .orElse(false);
  }
}
