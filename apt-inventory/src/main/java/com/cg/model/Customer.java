package com.cg.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "company_name")
    private String companyName;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "full_name")
    private String fullName;

    private String phone;

    @OneToOne
    @JoinColumn(name = "location_region_id")
    private LocationRegion locationRegion;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<LocationDelivery> locationDeliveries;

//    @OneToOne
//    @JoinColumn(name = "image_id")
//    private Image image;

}
