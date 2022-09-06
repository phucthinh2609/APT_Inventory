package com.cg.repository;

import com.cg.model.Inventory;
import com.cg.model.dto.InventoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
//    @Query(value = "SELECT new com.cg.model.dto.InventoryDTO (" +
//            "p.title, " +
//            "COUNT(inDe.product) " +
//            ") " +
//            "FROM InventoryDetail AS inDe, Product AS p " +
//            "WHERE inDe.product.id = p.id " +
//            "AND inDe.selled = false " +
//            "GROUP BY inDe.product "
//    )
//    @Query(value = "SELECT new com.cg.model.dto.InventoryDTO (" +
//                "inv.id, " +
//                "inv.available, " +
//                "p.title " +
//            ") " +
//            "FROM Inventory AS inv, Product AS p " +
//            "WHERE inv.product.id = p.id "
//    )
//    List<InventoryDTO> getAllInventory();
}
