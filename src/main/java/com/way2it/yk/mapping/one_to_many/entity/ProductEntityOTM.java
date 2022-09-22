package com.way2it.yk.mapping.one_to_many.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product")

public class ProductEntityOTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer price;
    /*@OneToMany(mappedBy = "productEntityOTM", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CartEntityOTM> cartEntityOTMList = new ArrayList<>();*/

    public ProductEntityOTM(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
