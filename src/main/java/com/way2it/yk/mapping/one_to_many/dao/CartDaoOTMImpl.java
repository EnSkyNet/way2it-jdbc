package com.way2it.yk.mapping.one_to_many.dao;

import com.way2it.yk.mapping.one_to_many.config.DatabaseConfig;
import com.way2it.yk.mapping.one_to_many.entity.CartEntityOTM;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartDaoOTMImpl implements CartDaoOTM {
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }
    @Override
    public List<CartEntityOTM> getAllCarts() {
        List<CartEntityOTM> cartEntities = new ArrayList<>();
        return entityManager.createQuery("SELECT cart FROM CartEntityOTM cart ", CartEntityOTM.class).getResultList();
    }

    @Override
    public Optional<CartEntityOTM> getCartById(Integer cartId) {
        return entityManager.createQuery("SELECT cart FROM CartEntityOTM cart WHERE cart.id =: cartId", CartEntityOTM.class)
                .setParameter("cartId", cartId)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void saveCart(CartEntityOTM cartEntityOTM) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(cartEntityOTM);
        transaction.commit();
    }

    @Override
    public void deleteCart(CartEntityOTM cartEntityOTM) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(cartEntityOTM);
        transaction.commit();
    }
}
