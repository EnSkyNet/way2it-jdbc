package com.way2it.yk.mapping.many_to_many.dao;

import com.way2it.yk.mapping.many_to_many.entity.BuyerEntityMTM;
import com.way2it.yk.mapping.many_to_many.entity.CartEntityMTM;

import java.util.List;
import java.util.Optional;

public interface BuyerDaoMTM {
    List<BuyerEntityMTM> getAllBuyers();

    Optional<BuyerEntityMTM> getBuyerById(Integer buyerId);

    void saveBuyer(BuyerEntityMTM buyerEntityMTM);
    void deleteBuyer(BuyerEntityMTM buyerEntityMTM);

    List<CartEntityMTM> getCartByBuyerId(Integer buyerId);
}
