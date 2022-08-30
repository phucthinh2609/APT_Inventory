package com.cg.controller.rest;


import com.cg.model.ComputerConfigurationParameter;
import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;
import com.cg.service.ComputerConfigurationParameter.ComputerConfigurationParameterService;
import com.cg.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ComputerConfigurationParameterService computerConfigurationParameterService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        List<Product> products = productService.findAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/detail/{productId}")
    public ResponseEntity<?> getById(@PathVariable Long productId) {

        Optional<Product> product = productService.findById(productId);

        if (!product.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @GetMapping("/edit/{productId}")
    public ResponseEntity<?> getByIdWithConfigurationParam(@PathVariable Long productId) {

        List<ComputerConfigurationParameter> computerConfigurationParameters = computerConfigurationParameterService.findAll();

        ProductDTO productDTO = new ProductDTO();

        Optional<Product> product = productService.findById(productId);

        if (!product.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        productDTO.setProduct(product.get());
        productDTO.setComputerConfigurationParameters(computerConfigurationParameters);

        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@RequestBody Product product) {

        Product newProduct = productService.save(product);

        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@RequestBody Product product) {

        Long productId = product.getId();

        if (!productService.existsById(productId)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Product updatedProduct = productService.save(product);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}
