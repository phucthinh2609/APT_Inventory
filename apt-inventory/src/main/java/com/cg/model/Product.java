package com.cg.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "products")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Product {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String title;

    @Digits(integer = 12, fraction = 0)
    @Column(name = "purchase_order_price")
    private BigDecimal purchaseOrderPrice;

    private String description;

    @Type( type = "json" )
    @Column(name = "configuration_detail", columnDefinition = "json")
    private Map<String, Object> configurationDetail;

    @OneToMany(targetEntity = Inventory.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Inventory> inventories;

    @OneToMany(targetEntity = ProductMedia.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<ProductMedia> productMedia;

    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<OrderDetail> orderDetails;

    @OneToMany(targetEntity = Comment.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Comment> comments;

    @OneToMany(targetEntity = Inventory.class, mappedBy = "product", fetch = FetchType.EAGER)
    private Set<InventoryDetail> inventoryDetails;
}
