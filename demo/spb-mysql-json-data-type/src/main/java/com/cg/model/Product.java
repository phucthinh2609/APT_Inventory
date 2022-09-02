package com.cg.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
//@SuppressWarnings("JpaAttributeTypeInspection")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(precision = 12, scale = 0, nullable = false, updatable = false)
    private BigDecimal price;

    @Type( type = "json" )
    @Column(name = "configuration_detail", columnDefinition = "json")
    private Map<String, Object> configurationDetail;
}
