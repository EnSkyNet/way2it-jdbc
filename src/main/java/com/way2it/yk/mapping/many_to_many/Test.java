package com.way2it.yk.mapping.many_to_many;

import com.way2it.yk.mapping.many_to_many.dao.BuyerDaoMTM;
import com.way2it.yk.mapping.many_to_many.dao.BuyerDaoMTMImpl;
import com.way2it.yk.mapping.many_to_many.entity.BuyerEntityMTM;
import com.way2it.yk.mapping.many_to_many.entity.SalerEntityMTM;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        BuyerDaoMTM buyerDao = new BuyerDaoMTMImpl();
        BuyerEntityMTM buyerEntityMTM = new BuyerEntityMTM("Nika", 2000);

        SalerEntityMTM salerEntityMTM = new SalerEntityMTM();
        salerEntityMTM.setName("Jons");

        buyerEntityMTM.setSalerEntityMTMList(List.of(salerEntityMTM));
        salerEntityMTM.setBuyerEntityMTMList(List.of(buyerEntityMTM));
        buyerDao.saveBuyer(buyerEntityMTM);

        System.out.println(buyerDao.getAllBuyers());
    }
}
