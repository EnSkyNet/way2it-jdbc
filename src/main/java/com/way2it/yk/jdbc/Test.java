package com.way2it.yk.jdbc;

import com.way2it.yk.jdbc.config.DatabaseConfig;
import com.way2it.yk.jdbc.dao.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConfig.getConnection();
        System.out.println(connection.getMetaData().getURL());

        BuyerDao buyerDao = new BuyerDaoImpl();
        CartDao cartDao = new CartDaoImpl();
        ProductDao productDao = new ProductDaoImpl();
        buyerDao.getAllBuyers().forEach(System.out::println);
        cartDao.getAllCarts().forEach(System.out::println);
        productDao.getAllProducts().forEach(System.out::println);

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
