package com.way2it.yk.mapping.one_to_many.dao;

import com.way2it.yk.mapping.one_to_many.entity.CartEntityOTM;

import java.util.List;
import java.util.Optional;

public interface CartDaoOTM {
    List<CartEntityOTM> getAllCarts();

    Optional<CartEntityOTM> getCartById(Integer Id);

    void saveCart(CartEntityOTM cartEntityOTM);
    void deleteCart(CartEntityOTM cartEntityOTM);

}
