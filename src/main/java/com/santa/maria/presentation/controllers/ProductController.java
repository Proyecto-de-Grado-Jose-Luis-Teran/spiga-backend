package com.santa.maria.presentation.controllers;

import com.santa.maria.application.requests.ProductCreateRequest;
import com.santa.maria.application.requests.ProductUpdateRequest;
import com.santa.maria.application.responses.ProductResponse;
import com.santa.maria.application.services.contracts.IProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
  private final IProductService productService;

  public ProductController(IProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{productId}")
  public ResponseEntity<?> getBranchById(@PathVariable("productId") UUID productId) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.getProductById(productId));
  }

  @GetMapping
  public ResponseEntity<?> getAll() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.findAllProducts());
  }

  @PostMapping
  public ResponseEntity<ProductResponse> createProduct(
          @Valid @RequestBody ProductCreateRequest productCreateRequest) {
    ProductResponse createdProduct = productService.createProduct(productCreateRequest);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createdProduct);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<ProductResponse> updateBranch(
          @PathVariable("productId") UUID productId,
          @Valid @RequestBody ProductUpdateRequest productUpdateRequest) {
    ProductResponse updateProduct = productService.updateProductById(productId, productUpdateRequest);

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
