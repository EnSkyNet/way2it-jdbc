package com.way2it.yk.mapping.one_to_one.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")

public class OrderEntityOTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer total;

    @OneToOne(cascade = CascadeType.ALL)
    private BuyerEntityOTO buyer;

    public OrderEntityOTO(Integer total, BuyerEntityOTO buyer) {
        this.total = total;
        this.buyer = buyer;
    }
}

