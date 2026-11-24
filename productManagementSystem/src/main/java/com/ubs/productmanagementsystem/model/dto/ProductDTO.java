package com.ubs.productmanagementsystem.model.dto;

import com.ubs.productmanagementsystem.model.Entity.Product;
import com.ubs.productmanagementsystem.model.Entity.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    private ProductStatus status;

    public static ProductDTO toProductDTO(Product entity) {
        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .status(entity.getStatus())
                .build();
    }

    public Product toEntity() {
        return Product.builder()
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .quantity(this.quantity)
                .status(this.status)
                .build();
    }
}
