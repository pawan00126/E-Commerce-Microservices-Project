package com.pawan.DTO_Mapper;

import com.pawan.Entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());

        return dto;
    }
}
