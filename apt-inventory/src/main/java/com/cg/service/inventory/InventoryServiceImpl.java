package com.cg.service.inventory;

import com.cg.model.Inventory;
import com.cg.model.dto.InventoryDTO;
import com.cg.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> findAll() {
        return null;
    }

    @Override
    public List<InventoryDTO> getAllInventory() {
        return null;
//        return inventoryRepository.getAllInventory();
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Inventory getById(Long id) {
        return null;
    }

    @Override
    public Inventory save(Inventory inventory) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
