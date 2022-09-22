package com.way2it.yk.mapping.one_to_one.dao;

import com.way2it.yk.mapping.one_to_one.config.DatabaseConfig;
import com.way2it.yk.mapping.one_to_one.entity.ProductEntityOTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoOTOImpl implements ProductDaoOTO {
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }


    @Override
    public List<ProductEntityOTO> getAllProducts() {
        List<ProductEntityOTO> productEntityOTO = new ArrayList<>();
        return entityManager.createQuery("SELECT product FROM ProductEntityOTO product ", ProductEntityOTO.class).getResultList();
    }

    @Override
    public Optional<ProductEntityOTO> getProductById(Integer productId) {
        return entityManager.createQuery("SELECT product FROM ProductEntityOTO product WHERE product.id =: productId", ProductEntityOTO.class)
                .setParameter("productId", productId)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void saveProduct(ProductEntityOTO productEntityOTO) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(productEntityOTO);
        transaction.commit();
    }

    @Override
    public void deleteProduct(ProductEntityOTO productEntityOTO) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(productEntityOTO);
        transaction.commit();

    }
}
