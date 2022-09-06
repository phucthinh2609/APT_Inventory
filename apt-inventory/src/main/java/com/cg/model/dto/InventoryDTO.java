package com.cg.model.dto;

import com.cg.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InventoryDTO {
    private String id;
    private int quantity;
    private int sold;
    private int available;
    private String title;

    public InventoryDTO(String id, int available, String title) {
        this.id = id;
        this.available = available;
        this.title = title;
    }
}