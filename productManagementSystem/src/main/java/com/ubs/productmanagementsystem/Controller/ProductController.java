package com.ubs.productmanagementsystem.Controller;

import com.ubs.productmanagementsystem.Service.ProductService;
import com.ubs.productmanagementsystem.model.dto.ProductDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductDTO.toProductDTO(productService.createProduct(dto.toEntity())));
    }


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts().stream().map(ProductDTO::toProductDTO).toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(ProductDTO.toProductDTO(productService.getProduct(id)));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(ProductDTO.toProductDTO(productService.updateProduct(id, dto.toEntity())));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ProductDTO> patchProduct(@PathVariable Integer id, @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(ProductDTO.toProductDTO(productService.patchProduct(id, dto.toEntity())));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProducts(@RequestParam String name) {
        return ResponseEntity.ok(productService.searchProducts(name).stream().map(ProductDTO::toProductDTO).toList());
    }
}