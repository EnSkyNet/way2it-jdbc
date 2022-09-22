package com.way2it.yk.mapping.one_to_one.dao;

import com.way2it.yk.mapping.one_to_one.entity.BuyerEntityOTO;
import com.way2it.yk.mapping.one_to_one.entity.CartEntityOTO;

import java.util.List;
import java.util.Optional;

public interface BuyerDaoOTO {
    List<BuyerEntityOTO> getAllBuyers();

    Optional<BuyerEntityOTO> getBuyerById(Integer buyerId);

    void saveBuyer(BuyerEntityOTO buyerEntityOTO);
    void deleteBuyer(BuyerEntityOTO buyerEntityOTO);

    List<CartEntityOTO> getCartByBuyerId(Integer buyerId);
}
