package com.cg.repository;

import com.cg.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


//    @Query("SELECT " +
//            "pm.product.id AS id, " +
//            "pm.product.name AS name, " +
//            "pm.id AS fileId, " +
//            "pm.fileName AS fileName, " +
//            "pm.fileFolder AS fileFolder, " +
//            "pm.fileUrl AS fileUrl, " +
//            "pm.fileType AS fileType " +
//        "FROM ProductMedia pm " +
//        "ORDER BY pm.product.id ASC"
//    )
//    Iterable<ProductMedia> findAllIProductDTO();
//
//
//    @Query("SELECT " +
//            "pm.product.id AS id, " +
//            "pm.product.name AS name, " +
//            "pm.id AS fileId, " +
//            "pm.fileName AS fileName, " +
//            "pm.fileFolder AS fileFolder, " +
//            "pm.fileUrl AS fileUrl, " +
//            "pm.fileType AS fileType " +
//            "FROM ProductMedia pm " +
//            "WHERE pm.product.id = :id"
//    )
//    Iterable<ProductMedia> findIProductDTOById(@Param("id") String id);

}
