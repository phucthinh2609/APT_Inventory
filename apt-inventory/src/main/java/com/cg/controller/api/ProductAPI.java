package com.cg.controller.api;


import com.cg.exception.DataInputException;
import com.cg.model.Product;
import com.cg.model.ProductMedia;
import com.cg.model.dto.ProductDTO;
import com.cg.model.dto.ProductRender;
import com.cg.service.product.ProductService;
import com.cg.service.productMedia.ProductMediaService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMediaService productMediaService

    @Autowired
    private AppUtils appUtils;

    @GetMapping
    public ResponseEntity<Iterable<?>> findAll() {
        try {
            Iterable<ProductMedia> productMediaList = productMediaService.findAllByOrderByProductIdAsc();

            if (productMediaList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }


            String tempId = "";
            HashMap<String, String> fileUrls = new HashMap<>();
            ProductRender productRender = new ProductRender();
            HashSet<ProductRender> productRenderList = new HashSet<>();

            for (ProductMedia productMedia : productMediaList) {
                if (tempId.equals(productMedia.getProduct().getId())) {
                    fileUrls.put(productMedia.getId(), productMedia.getFileUrl());
                } else {
                    productRender = new ProductRender();
                    fileUrls = new HashMap<>();
                    productRender.setId(productMedia.getProduct().getId());
                    productRender.setName(productMedia.getProduct().getName());
                    fileUrls.put(productMedia.getId(), productMedia.getFileUrl());
                }
                productRender.setFileUrls(fileUrls);

                productRenderList.add(productRender);
                tempId = productMedia.getProduct().getId();
            }
            return new ResponseEntity<>(productRenderList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
//        Optional<Product> currentProduct = productService.findById(id);
//
//        if (!currentProduct.isPresent()) {
//            throw new DataInputException("Product is not found");
//        }
//
//        List<ProductMediaDTO> currentProductMediaList = productMediaService.findAllByProductId(currentProduct.get().getId());
//
//        return new ResponseEntity<>(currentProductMediaList, HttpStatus.OK);
        Iterable<ProductMedia> productMediaList = productMediaService.findAllByProductId(id);
        if (productMediaList == null) {
            throw new DataInputException("Product is not found");
        }
        return new ResponseEntity<>(productMediaList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return appUtils.mapErrorToResponse(bindingResult);
        try {
            Product createdProduct = productService.create(productDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Product creation information is not valid, please check the information again");
        }
    }
//
//    @PutMapping("/edit/{mediaId}")
//    public ResponseEntity<?> editMedia(@PathVariable String mediaId) {
//
//        if (bindingResult.hasErrors())
//            return appUtils.mapErrorToResponse(bindingResult);
//
//        try {
//            Product createdProduct = productService.create(productDTO);
//
////            IProductDTO iProductDTO =  productService.findIProductDTOById(createdProduct.getId());
//
//            return new ResponseEntity<>(HttpStatus.CREATED);
//
//        } catch (DataIntegrityViolationException e) {
//            throw new DataInputException("Product creation information is not valid, please check the information again");
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) throws IOException {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            productService.delete(product.get());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            throw new DataInputException("Invalid product information");
        }
    }

    private HashSet<ProductRender> convertToProductRender(Iterable<ProductMedia> productMediaList) {
        String tempId = "";
        HashMap<String, String> fileUrls = new HashMap<>();
        ProductRender productRender = new ProductRender();
        HashSet<ProductRender> productRenderList = new HashSet<>();

        for (ProductMedia productMedia : productMediaList) {
            if (tempId.equals(productMedia.getProduct().getId())) {
                fileUrls.put(productMedia.getId(), productMedia.getFileUrl());
            } else {
                productRender = new ProductRender();
                fileUrls = new HashMap<>();
                productRender.setId(productMedia.getProduct().getId());
                productRender.setName(productMedia.getProduct().getName());
                fileUrls.put(productMedia.getId(), productMedia.getFileUrl());
            }
            productRender.setFileUrls(fileUrls);

            productRenderList.add(productRender);
            tempId = productMedia.getProduct().getId();
        }
        return productRenderList;
    }
}