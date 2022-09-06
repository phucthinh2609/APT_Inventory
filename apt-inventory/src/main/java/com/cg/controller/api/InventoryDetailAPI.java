package com.cg.controller.api;

import com.cg.model.InventoryDetail;
import com.cg.model.dto.InventoryDetailDTO;
import com.cg.service.inventoryDetail.InventoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventoryDetails")
public class InventoryDetailAPI {

    @Autowired
    private InventoryDetailService inventoryDetailService;

    @GetMapping
    public ResponseEntity<?> getAllDTO() {

        List<InventoryDetailDTO> inventoryDetails = inventoryDetailService.findAllDTO();

        return new ResponseEntity<>(inventoryDetails, HttpStatus.OK);
    }
}
