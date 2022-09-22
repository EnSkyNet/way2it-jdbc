package com.way2it.yk.mapping.one_to_one.dao;

import com.way2it.yk.mapping.one_to_one.config.DatabaseConfig;
import com.way2it.yk.mapping.one_to_one.entity.CartEntityOTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartDaoOTOImpl implements CartDaoOTO {
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }
    @Override
    public List<CartEntityOTO> getAllCarts() {
        List<CartEntityOTO> cartEntities = new ArrayList<>();
        return entityManager.createQuery("SELECT cart FROM CartEntityOTO cart ", CartEntityOTO.class).getResultList();
    }

    @Override
    public Optional<CartEntityOTO> getCartById(Integer cartId) {
        return entityManager.createQuery("SELECT cart FROM CartEntityOTO cart WHERE cart.id =: cartId", CartEntityOTO.class)
                .setParameter("cartId", cartId)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void saveCart(CartEntityOTO cartEntityOTO) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(cartEntityOTO);
        transaction.commit();
    }

    @Override
    public void deleteCart(CartEntityOTO cartEntityOTO) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(cartEntityOTO);
        transaction.commit();
    }
}
