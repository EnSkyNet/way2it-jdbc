package com.way2it.yk.jdbc.dao;

import com.way2it.yk.jdbc.entity.CartEntity;

import java.util.List;

public interface CartDao {
    List<CartEntity> getAllCarts();

    void addCart(Integer buyerId, Integer productId, Integer product_quantity, String shop);

    CartEntity getCartById(Integer Id);

    void updateCart(Integer productId, Integer product_quantity, Integer cartId);
    void deleteCart(Integer cartId);

}
