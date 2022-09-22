package com.way2it.yk.jpa;

import com.way2it.yk.jpa.config.DatabaseConfig;
import com.way2it.yk.jpa.dao.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        BuyerDao buyerDao = new BuyerDaoImpl();
        CartDao cartDao = new CartDaoImpl();
        ProductDao productDao = new ProductDaoImpl();
        buyerDao.getAllBuyers().forEach(System.out::println);
        cartDao.getAllCarts().forEach(System.out::println);
        productDao.getAllProducts().forEach(System.out::println);
        System.out.println(buyerDao.getBuyerById(5));
        System.out.println(cartDao.getCartById(3));
        System.out.println(productDao.getProductById(15));

        //System.out.println(buyerDao.getBuyerById(1));
        //System.out.println();
        // buyerDao.addBuyer("Victor",250);
        //buyerDao.getAllBuyers().forEach(System.out::println);
        //buyerDao.updateBuyer("Mikola", 600, 5);
        //System.out.println(buyerDao.getBuyerById(5));

        //buyerDao.deleteBuyer( 51);
       // buyerDao.getAllBuyers().forEach(System.out::println);
    }
}
