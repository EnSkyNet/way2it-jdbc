package com.way2it.yk.mapping.one_to_many;

import com.way2it.yk.mapping.one_to_many.dao.*;
import com.way2it.yk.mapping.one_to_many.entity.BuyerEntityOTM;
import com.way2it.yk.mapping.one_to_many.entity.CartEntityOTM;
import com.way2it.yk.mapping.one_to_many.entity.ProductEntityOTM;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        BuyerDaoOTM buyerDaoOTM = new BuyerDaoOTMImpl();
      /*  BuyerEntityOTM buyerEntityOTM = new BuyerEntityOTM("Boris", 600);
        ProductEntityOTM productEntityOTM = new ProductEntityOTM("carrot",2);
        CartEntityOTM cartEntityOTM = new CartEntityOTM();
        cartEntityOTM.setBuyerEntityOTM(buyerEntityOTM);
        cartEntityOTM.setProductEntityOTM(productEntityOTM);
        cartEntityOTM.setProduct_quantity(5);
        cartEntityOTM.setShop("Inter");
        buyerEntityOTM.setCartEntityOTMList(List.of(cartEntityOTM));
        buyerDaoOTM.saveBuyer(buyerEntityOTM);
        Integer id = buyerEntityOTM.getId();*/
       //System.out.println(buyerDaoOTM.getBuyerById(60));

        List<CartEntityOTM> cartEntityOTM = buyerDaoOTM.getCartByBuyerId(60);
        System.out.println(cartEntityOTM);



       /* CartDaoOTM cartDaoOTM = new CartDaoOTMImpl();
        ProductDaoOTM productDaoOTM = new ProductDaoOTMImpl();*/

        /*buyerDaoOTM.getAllBuyers().forEach(System.out::println);
        cartDaoOTM.getAllCarts().forEach(System.out::println);
        productDaoOTM.getAllProducts().forEach(System.out::println);
        System.out.println(buyerDaoOTM.getBuyerById(5));
        System.out.println(cartDaoOTM.getCartById(3));
        System.out.println(productDaoOTM.getProductById(15));*/




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
