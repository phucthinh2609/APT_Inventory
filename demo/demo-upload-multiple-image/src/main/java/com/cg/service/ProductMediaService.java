package com.cg.service;

import com.cg.model.ProductMedia;

import java.util.List;

public interface ProductMediaService {

    Iterable<ProductMedia> findAll();

    Iterable<ProductMedia> findAllByProductId(String productId);

    ProductMedia create(ProductMedia productMedia);

    void delete(ProductMedia productMedia);

    Iterable<ProductMedia> findAllByOrderByProductIdAsc();
}
