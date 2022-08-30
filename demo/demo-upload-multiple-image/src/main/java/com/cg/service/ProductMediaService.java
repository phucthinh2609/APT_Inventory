package com.cg.service;

import com.cg.model.ProductMedia;
import com.cg.model.dto.ProductMediaDTO;

import java.util.List;

public interface ProductMediaService {

    Iterable<ProductMedia> findAll();

    List<ProductMediaDTO> findAllByProductId(String productId);

    ProductMedia create(ProductMedia productMedia);

    void delete(ProductMedia productMedia);

}
