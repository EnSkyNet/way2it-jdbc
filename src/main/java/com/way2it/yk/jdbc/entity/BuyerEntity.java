package com.way2it.yk.jdbc.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BuyerEntity {
    private Integer id;
    private String name;
    private Integer money;
}
