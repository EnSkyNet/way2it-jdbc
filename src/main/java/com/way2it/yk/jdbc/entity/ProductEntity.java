package com.way2it.yk.jdbc.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProductEntity {
    private Integer id;
    private String name;
    private Integer price;
}
