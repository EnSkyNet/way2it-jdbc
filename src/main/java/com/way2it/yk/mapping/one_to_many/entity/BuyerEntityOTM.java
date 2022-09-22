package com.way2it.yk.mapping.one_to_many.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "buyer")

public class BuyerEntityOTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer money;
    @OneToMany(mappedBy = "buyerEntityOTM", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CartEntityOTM> cartEntityOTMList = new ArrayList<>();

    @Override
    public String toString() {
        return "BuyerEntityOTM{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", shop=" + cartEntityOTMList
                .stream().map(CartEntityOTM::getShop).toList()
                +'}';
    }

    public BuyerEntityOTM(String name, Integer money) {
        this.name = name;
        this.money = money;
    }
}
