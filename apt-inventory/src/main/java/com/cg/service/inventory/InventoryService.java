package com.cg.service.inventory;

import com.cg.model.Inventory;
import com.cg.model.dto.InventoryDTO;
import com.cg.service.IGeneralService;

import java.util.List;

public interface InventoryService extends IGeneralService<Inventory> {
    List<InventoryDTO> getAllInventory();
}
