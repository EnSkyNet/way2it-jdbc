package com.way2it.yk.jpa.dao;

import com.way2it.yk.jpa.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<ProductEntity> getAllProducts();

    Optional<ProductEntity> getProductById(Integer Id);

    void saveProduct(ProductEntity productEntity);
    void deleteProduct(ProductEntity productEntity);

}
