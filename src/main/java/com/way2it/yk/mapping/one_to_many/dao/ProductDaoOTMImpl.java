package com.way2it.yk.mapping.one_to_many.dao;

import com.way2it.yk.mapping.one_to_many.config.DatabaseConfig;
import com.way2it.yk.mapping.one_to_many.entity.ProductEntityOTM;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoOTMImpl implements ProductDaoOTM {
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }


    @Override
    public List<ProductEntityOTM> getAllProducts() {
        List<ProductEntityOTM> productEntityOTM = new ArrayList<>();
        return entityManager.createQuery("SELECT product FROM ProductEntityOTM product ", ProductEntityOTM.class).getResultList();
    }

    @Override
    public Optional<ProductEntityOTM> getProductById(Integer productId) {
        return entityManager.createQuery("SELECT product FROM ProductEntityOTM product WHERE product.id =: productId", ProductEntityOTM.class)
                .setParameter("productId", productId)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void saveProduct(ProductEntityOTM productEntityOTM) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(productEntityOTM);
        transaction.commit();
    }

    @Override
    public void deleteProduct(ProductEntityOTM productEntityOTM) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(productEntityOTM);
        transaction.commit();

    }
}
