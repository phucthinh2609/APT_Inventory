//package com.cg.repository;
//
//import com.cg.model.ProductDemo;
//import com.cg.model.dto.IProductDTO;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public interface ProductRepository extends JpaRepository<ProductDemo, String> {
//
//
//    @Query("SELECT " +
//            "pm.product.id AS id, " +
//            "pm.product.name AS name, " +
//            "pm.product.description AS description, " +
//            "pm.id AS fileId, " +
//            "pm.fileName AS fileName, " +
//            "pm.fileFolder AS fileFolder, " +
//            "pm.fileUrl AS fileUrl, " +
//            "pm.fileType AS fileType " +
//        "FROM ProductMediaDemo pm " +
//        "ORDER BY pm.product.ts ASC"
//    )
//    Iterable<IProductDTO> findAllIProductDTO();
//
//
//    @Query("SELECT " +
//            "pm.product.id AS id, " +
//            "pm.product.name AS name, " +
//            "pm.product.description AS description, " +
//            "pm.id AS fileId, " +
//            "pm.fileName AS fileName, " +
//            "pm.fileFolder AS fileFolder, " +
//            "pm.fileUrl AS fileUrl, " +
//            "pm.fileType AS fileType " +
//        "FROM ProductMediaDemo pm " +
//        "WHERE pm.product.id = :id"
//    )
//    IProductDTO findIProductDTOById(@Param("id") String id);
//
//}
