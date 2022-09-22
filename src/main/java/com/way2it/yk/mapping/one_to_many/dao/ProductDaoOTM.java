package com.way2it.yk.mapping.one_to_many.dao;

import com.way2it.yk.mapping.one_to_many.entity.ProductEntityOTM;

import java.util.List;
import java.util.Optional;

public interface ProductDaoOTM {
    List<ProductEntityOTM> getAllProducts();

    Optional<ProductEntityOTM> getProductById(Integer Id);

    void saveProduct(ProductEntityOTM productEntityOTM);
    void deleteProduct(ProductEntityOTM productEntityOTM);

}
