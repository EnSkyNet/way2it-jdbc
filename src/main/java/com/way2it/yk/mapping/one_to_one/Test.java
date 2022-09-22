package com.way2it.yk.mapping.one_to_one;

import com.way2it.yk.mapping.one_to_one.dao.*;
import com.way2it.yk.mapping.one_to_one.entity.BuyerEntityOTO;
import com.way2it.yk.mapping.one_to_one.entity.OrderEntityOTO;

import java.util.List;

public class Test {
    public static void main(String[] args) {
       /* SessionFactory sessionFactory = HibernateSessionConfiguration.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();*/

        OrderDaoOTO orderDao = new OrderDaoOTOImpl();
        BuyerDaoOTO buyerDao = new BuyerDaoOTOImpl();

        BuyerEntityOTO buyerEntityOTO = new BuyerEntityOTO("Nika", 2000);

        OrderEntityOTO orderEntityOTO = new OrderEntityOTO( );
        orderEntityOTO.setTotal(50);
        buyerEntityOTO.setCartEntityOTOList(List.of());
        buyerEntityOTO.setOrderEntityOTO(orderEntityOTO);
        orderEntityOTO.setBuyer(buyerEntityOTO);

        //orderDao.saveOrder(orderEntityOTO);
        System.out.println(orderDao.findAll());
        System.out.println(orderDao.findById(2));
    }
}
