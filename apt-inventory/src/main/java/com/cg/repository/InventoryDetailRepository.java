package com.cg.repository;

import com.cg.model.InventoryDetail;
import com.cg.model.dto.InventoryDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryDetailRepository extends JpaRepository<InventoryDetail, String> {

    @Query(value = "SELECT new com.cg.model.dto.InventoryDetailDTO (" +
                "inDe.id, " +
                "p.title, " +
                "inDe.productCode, " +
                "inDe.purchaseOrderPrice, " +
                "inDe.stockInPrice, " +
                "inDe.selled, " +
                "inDe.grossProfit " +
                ") " +
            "FROM InventoryDetail AS inDe, Product AS p " +
            "WHERE inDe.product.id = p.id" +
            ""
    )

    List<InventoryDetailDTO> findAllDTO();
}
