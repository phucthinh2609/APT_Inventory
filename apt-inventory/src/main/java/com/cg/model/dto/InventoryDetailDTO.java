package com.cg.model.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InventoryDetailDTO {
    private String id;
    private String title;
    private String productCode;
    private BigDecimal purchaseOrderPrice;
    private BigDecimal stockInPrice;
    private boolean selled;
    private BigDecimal grossProfit;
}
