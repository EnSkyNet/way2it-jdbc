package com.way2it.yk.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cart")

public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer buyer_id;
    @Column
    private Integer product_id;
    @Column
    private Integer product_quantity;
    @Column
    private String shop;
}
