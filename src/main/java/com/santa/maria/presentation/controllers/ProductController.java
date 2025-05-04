package com.santa.maria.presentation.controllers;

import com.santa.maria.application.mappers.IProductMapper;
import com.santa.maria.application.requests.ProductCreateRequest;
import com.santa.maria.application.requests.ProductUpdateRequest;
import com.santa.maria.application.responses.ProductResponse;
import com.santa.maria.application.services.contracts.IProductService;
import com.santa.maria.domain.entities.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
  private final IProductService productService;
  private final IProductMapper productMapper;

  public ProductController(IProductService productService, IProductMapper productMapper) {
    this.productService = productService;
    this.productMapper = productMapper;
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductResponse> getBranchById(@PathVariable("productId") UUID productId) {
    Optional<Product> product = productService.getProductById(productId);
    ProductResponse productResponse = productMapper.mapToProductResponse(product.get());

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productResponse);
  }

  @GetMapping
  public ResponseEntity<List<ProductResponse>> getAll() {
    List<ProductResponse> productResponses =
            productService
                    .getAllProducts()
                    .stream()
                    .map(productMapper::mapToProductResponse)
                    .toList();

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productResponses);
  }

  @PostMapping
  public ResponseEntity<ProductResponse> createProduct(
          @Valid @RequestBody ProductCreateRequest productCreateRequest) {
    Product product = productService.createProduct(productCreateRequest);
    ProductResponse createdProduct = productMapper.mapToProductResponse(product);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createdProduct);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<ProductResponse> updateBranch(
          @PathVariable("productId") UUID productId,
          @Valid @RequestBody ProductUpdateRequest productUpdateRequest) {
    Product product = productService.updateProductById(productId, productUpdateRequest);
    ProductResponse updateProduct = productMapper.mapToProductResponse(product);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(updateProduct);
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<?> deleteBranch(@PathVariable("productId") UUID productId) {
    boolean isProductDeleted = productService.deleteProductById(productId);

    if (!isProductDeleted) {
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body("Product with id " + productId + " not found");
    }

    return ResponseEntity
            .status(HttpStatus.OK)
            .body("Product deleted successfully");
  }
}
