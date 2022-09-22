package com.way2it.yk.mapping.one_to_many.dao;

import com.way2it.yk.mapping.one_to_many.entity.BuyerEntityOTM;
import com.way2it.yk.mapping.one_to_many.entity.CartEntityOTM;

import java.util.List;
import java.util.Optional;

public interface BuyerDaoOTM {
    List<BuyerEntityOTM> getAllBuyers();

    Optional<BuyerEntityOTM> getBuyerById(Integer buyerId);

    void saveBuyer(BuyerEntityOTM buyerEntityOTM);
    void deleteBuyer(BuyerEntityOTM buyerEntityOTM);

    List<CartEntityOTM> getCartByBuyerId(Integer buyerId);
}
