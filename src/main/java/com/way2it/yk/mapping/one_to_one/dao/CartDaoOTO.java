package com.way2it.yk.mapping.one_to_one.dao;

import com.way2it.yk.mapping.one_to_one.entity.CartEntityOTO;

import java.util.List;
import java.util.Optional;

public interface CartDaoOTO {
    List<CartEntityOTO> getAllCarts();

    Optional<CartEntityOTO> getCartById(Integer Id);

    void saveCart(CartEntityOTO cartEntityOTO);
    void deleteCart(CartEntityOTO cartEntityOTO);

}
