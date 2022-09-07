package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "product_uuid")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String productUuid;

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

    @OneToMany(targetEntity = Inventory.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Inventory> inventories;

    @OneToMany(targetEntity = ProductMedia.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<ProductMedia> productMedia;

    @OneToMany(targetEntity = TechSpecTemp.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<TechSpecTemp> techSpecTemps;

    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<OrderDetail> orderDetails;

    @OneToMany(targetEntity = Comment.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Comment> comments;
}
