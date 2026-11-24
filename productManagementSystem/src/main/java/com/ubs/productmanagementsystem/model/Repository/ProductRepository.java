package com.ubs.productmanagementsystem.model.Repository;

import com.ubs.productmanagementsystem.model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
