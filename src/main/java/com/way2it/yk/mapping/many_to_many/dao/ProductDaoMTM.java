package com.way2it.yk.mapping.many_to_many.dao;

import com.way2it.yk.mapping.many_to_many.entity.ProductEntityMTM;

import java.util.List;
import java.util.Optional;

public interface ProductDaoMTM {
    List<ProductEntityMTM> getAllProducts();

    Optional<ProductEntityMTM> getProductById(Integer Id);

    void saveProduct(ProductEntityMTM productEntityMTM);
    void deleteProduct(ProductEntityMTM productEntityMTM);

}
