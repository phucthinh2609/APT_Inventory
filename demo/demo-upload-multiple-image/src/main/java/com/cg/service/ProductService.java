package com.cg.service;

import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;

import java.io.IOException;
import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAll();

    Optional<Product> findById(String id);

//    Iterable<IProductMediaDTO> findAllIProductDTO();
//
//    Iterable<IProductMediaDTO> findIProductDTOById(String id);

    Product create(ProductDTO productDTO);

    void delete(Product product) throws IOException;


}
