package com.way2it.yk.mapping.one_to_one.entity;

import com.way2it.yk.mapping.one_to_many.entity.CartEntityOTM;
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

public class ProductEntityOTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer price;


    public ProductEntityOTO(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}