package com.pawan.Controller;

import com.pawan.DTO_Mapper.ProductDTO;
import com.pawan.DTO_Mapper.ProductMapper;
import com.pawan.Entity.Product;
import com.pawan.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ProductDTO createProduct(@RequestBody Product product) {
        return ProductMapper.toDTO(service.createProduct(product));
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return service.getAllProducts()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();

    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        var product = service.getProductById(id);

        if(product==null){
            return dummyProduct();
        }
        return ProductMapper.toDTO(product);
    }


    private ProductDTO dummyProduct(){
        ProductDTO dummy = new ProductDTO();
        dummy.setId(0L);
        dummy.setName("product not found");
        dummy.setPrice(0L);

        return dummy;
    }
}

