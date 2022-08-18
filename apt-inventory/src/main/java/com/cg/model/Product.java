package com.cg.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String title;

    @Column(name = "product_code")
    private String productCode;

    @Digits(integer = 10, fraction = 0)
    @Column(name = "stock_in_price")
    private BigDecimal stockInPrice;

    @Digits(integer = 10, fraction = 0)
    @Column(name = "purchase_order_price")
    private BigDecimal purchaseOrderPrice;

    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Inventory> inventories;
}
