package com.way2it.yk.jpa.dao;

import com.way2it.yk.jpa.entity.CartEntity;

import java.util.List;
import java.util.Optional;

public interface CartDao {
    List<CartEntity> getAllCarts();

    Optional<CartEntity> getCartById(Integer Id);

    void saveCart(CartEntity cartEntity);
    void deleteCart(CartEntity cartEntity);

}
