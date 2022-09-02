package com.cg.controller.api;


import com.cg.exception.DataInputException;
import com.cg.model.Product;
import com.cg.model.ProductMedia;
import com.cg.model.dto.IProductDTO;
import com.cg.model.dto.ProductDTO;
import com.cg.model.dto.ProductDTOs;
import com.cg.model.dto.ProductMediaDTO;
import com.cg.service.ProductMediaService;
import com.cg.service.ProductService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMediaService productMediaService;

    @Autowired
    private AppUtils appUtils;

    @GetMapping
    public ResponseEntity<Iterable<?>> findAll() {
        try {
            Iterable<IProductDTO> iProductDTOS = productService.findAllIProductDTO();

            if (iProductDTOS == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            String tempId = "";
            HashMap<String, String> fileUrls = new HashMap<>();
            ProductDTOs productDTOs = new ProductDTOs();
            HashSet<ProductDTOs> productDTOsList = new HashSet<>();

            for (IProductDTO iProductDTO : iProductDTOS) {
                if (tempId.equals(iProductDTO.getId())) {
                    fileUrls.put(iProductDTO.getFileId(),iProductDTO.getFileUrl());
                } else {
                    productDTOs = new ProductDTOs();
                    fileUrls = new HashMap<>();
                    productDTOs.setId(iProductDTO.getId());
                    productDTOs.setName(iProductDTO.getName());
                    fileUrls.put(iProductDTO.getFileId(),iProductDTO.getFileUrl());
                }
                productDTOs.setFileUrls(fileUrls);

                productDTOsList.add(productDTOs);
                tempId = iProductDTO.getId();
            }
            return new ResponseEntity<>(productDTOsList, HttpStatus.OK);
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
        Iterable<IProductDTO> iProductDTOs = productService.findIProductDTOById(id);

        if (iProductDTOs == null) {
            throw new DataInputException("Product is not found");
        }

        return new ResponseEntity<>(iProductDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated ProductDTO productDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return appUtils.mapErrorToResponse(bindingResult);

        try {
            Product createdProduct = productService.create(productDTO);

//            IProductDTO iProductDTO =  productService.findIProductDTOById(createdProduct.getId());

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

}