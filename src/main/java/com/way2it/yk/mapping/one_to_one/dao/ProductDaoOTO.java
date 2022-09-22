package com.way2it.yk.mapping.one_to_one.dao;

import com.way2it.yk.mapping.one_to_one.entity.ProductEntityOTO;

import java.util.List;
import java.util.Optional;

public interface ProductDaoOTO {
    List<ProductEntityOTO> getAllProducts();

    Optional<ProductEntityOTO> getProductById(Integer Id);

    void saveProduct(ProductEntityOTO productEntityOTO);
    void deleteProduct(ProductEntityOTO productEntityOTO);

}
