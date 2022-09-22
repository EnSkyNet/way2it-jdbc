package com.way2it.yk.jdbc.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CartEntity {
    private Integer id;
    private Integer buyer_id;
    private Integer product_id;
    private Integer product_quantity;
    private String shop;
}
