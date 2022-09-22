package com.way2it.yk.mapping.one_to_many.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cart")

public class CartEntityOTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    private BuyerEntityOTM buyerEntityOTM;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntityOTM productEntityOTM;
    @Column
    private Integer product_quantity;
    @Column
    private String shop;

    @Override
    public String toString() {
        return "CartEntityOTM{" +
                "id=" + id +
                ", buyerEntityOTM=" + buyerEntityOTM +
                ", productEntityOTM=" + productEntityOTM +
                ", product_quantity=" + product_quantity +
                ", shop='" + shop + '\'' +
                '}';
    }
}
