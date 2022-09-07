package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "quantity_total")
    private int quantityTotal;

    @ManyToOne
    @JoinColumn(name = "location_delivery_id", nullable = false)
    private LocationDelivery locationDelivery;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderDetail> orderDetails;
}
