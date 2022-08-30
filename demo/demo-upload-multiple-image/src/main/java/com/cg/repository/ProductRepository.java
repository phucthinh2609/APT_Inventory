package com.cg.repository;

import com.cg.model.Product;
import com.cg.model.dto.IProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


    @Query("SELECT " +
            "pm.product.id AS id, " +
            "pm.product.name AS name, " +
            "pm.id AS fileId, " +
            "pm.fileName AS fileName, " +
            "pm.fileFolder AS fileFolder, " +
            "pm.fileUrl AS fileUrl, " +
            "pm.fileType AS fileType " +
        "FROM ProductMedia pm " +
        "ORDER BY pm.product.id ASC"
    )
    Iterable<IProductDTO> findAllIProductDTO();


    @Query("SELECT " +
            "pm.product.id AS id, " +
            "pm.product.name AS name, " +
            "pm.id AS fileId, " +
            "pm.fileName AS fileName, " +
            "pm.fileFolder AS fileFolder, " +
            "pm.fileUrl AS fileUrl, " +
            "pm.fileType AS fileType " +
            "FROM ProductMedia pm " +
            "WHERE pm.product.id = :id"
    )
    Iterable<IProductDTO> findIProductDTOById(@Param("id") String id);

}
