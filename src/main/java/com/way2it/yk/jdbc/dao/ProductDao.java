package com.way2it.yk.jdbc.dao;

import com.way2it.yk.jdbc.entity.CartEntity;
import com.way2it.yk.jdbc.entity.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> getAllProducts();

    void addProduct(String name, Integer price);

    ProductEntity getProductById(Integer Id);

    void updateProduct(String name ,Integer price, Integer productId);
    void deleteProduct(Integer productId);

}
