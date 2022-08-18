package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
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

    private String title;



    private String description;

//    @OneToMany(targetEntity = ProductMedia.class, mappedBy = "product", fetch = FetchType.EAGER)
//    private Set<ProductMedia> productMedia;
//
//    @OneToMany(targetEntity = TechSpecTemp.class, mappedBy = "product", fetch = FetchType.EAGER)
//    private Set<TechSpecTemp> techSpecTemps;

//    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "product", fetch = FetchType.EAGER)
//    private Set<OrderDetail> orderDetails;
}
