//package com.cg.service;
//
//
//import com.cg.model.ProductMediaDemo;
//import com.cg.repository.ProductMediaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@Transactional
//public class ProductMediaServiceImpl implements ProductMediaService {
//
//    @Autowired
//    private ProductMediaRepository productMediaRepository;
//
//    @Override
//    public Iterable<ProductMediaDemo> findAll() {
//        return productMediaRepository.findAll();
//    }
//
//    @Override
//    public ProductMediaDemo create(ProductMediaDemo productMediaDemo) {
//        return productMediaRepository.save(productMediaDemo);
//    }
//
//    @Override
//    public void delete(ProductMediaDemo productMediaDemo) {
//        productMediaRepository.delete(productMediaDemo);
//    }
//}
