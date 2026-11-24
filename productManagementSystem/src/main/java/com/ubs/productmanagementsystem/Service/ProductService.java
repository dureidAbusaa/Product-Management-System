package com.ubs.productmanagementsystem.Service;

import com.ubs.productmanagementsystem.model.Repository.ProductRepository;
import com.ubs.productmanagementsystem.model.Entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @Transactional
    public Product updateProduct(Integer id, Product product) {

        Product existingProduct = getProduct(id);

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setStatus(product.getStatus());

        return productRepository.save(existingProduct);
    }

    @Transactional
    public Product patchProduct(Integer id, Product product) {

        Product existingProduct = getProduct(id);

        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }

        if (product.getDescription() != null) {
            existingProduct.setDescription(product.getDescription());
        }

        if (product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }

        if (product.getQuantity() != null) {
            existingProduct.setQuantity(product.getQuantity());
        }

        if (product.getStatus() != null) {
            existingProduct.setStatus(product.getStatus());
        }

        return productRepository.save(existingProduct);
    }

    @Transactional
    public void deleteProduct(Integer id) {

        Product product = getProduct(id);

        productRepository.delete(product);
    }

    public List<Product> searchProducts(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}