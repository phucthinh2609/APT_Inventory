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
@Table(name = "tech_specs")
public class TechSpec {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String value;

    @Column(name = "parent_id")
    private String parentId;

    @OneToMany(targetEntity = TechSpecTemp.class, mappedBy = "techSpec")
    private Set<TechSpecTemp> techSpecTemps;
}
