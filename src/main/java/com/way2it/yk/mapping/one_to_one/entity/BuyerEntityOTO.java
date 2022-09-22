package com.way2it.yk.mapping.one_to_one.entity;

import com.way2it.yk.mapping.one_to_one.config.HibernateSessionConfiguration;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

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

public class BuyerEntityOTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer money;
    @OneToMany(mappedBy = "buyerEntityOTO", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CartEntityOTO> cartEntityOTOList = new ArrayList<>();

    @OneToOne(mappedBy = "buyer", cascade = CascadeType.ALL)
    private OrderEntityOTO orderEntityOTO;

    @Override
    public String toString() {
        return "BuyerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                +'}';
    }

    public BuyerEntityOTO(String name, Integer money) {
        this.name = name;
        this.money = money;
    }
}
