package com.way2it.yk.mapping.one_to_many.dao;

import com.way2it.yk.mapping.one_to_many.config.DatabaseConfig;
import com.way2it.yk.mapping.one_to_many.entity.BuyerEntityOTM;
import com.way2it.yk.mapping.one_to_many.entity.CartEntityOTM;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BuyerDaoOTMImpl implements BuyerDaoOTM {

    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }

    @Override
    public List<BuyerEntityOTM> getAllBuyers() {
        List<BuyerEntityOTM> buyerEntities = new ArrayList<>();
        return entityManager.createQuery("SELECT buyer FROM BuyerEntityOTM buyer ", BuyerEntityOTM.class).getResultList();
    }

    @Override
    public void saveBuyer(BuyerEntityOTM buyerEntityOTM) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(buyerEntityOTM);
        transaction.commit();
    }

    @Override
    public Optional<BuyerEntityOTM> getBuyerById(Integer buyerId) {
        return entityManager.createQuery("SELECT buyer FROM BuyerEntityOTM buyer WHERE buyer.id =: buyerId", BuyerEntityOTM.class)
                .setParameter("buyerId", buyerId)
                .getResultList()
                .stream()
                .findFirst();
    }


     @Override
    public void deleteBuyer(BuyerEntityOTM buyerEntityOTM) {
         EntityTransaction transaction = entityManager.getTransaction();
         transaction.begin();
         entityManager.remove(buyerEntityOTM);
         transaction.commit();
    }

    @Override
    public List<CartEntityOTM> getCartByBuyerId(Integer buyerId) {
        return entityManager.createQuery("SELECT buyer FROM BuyerEntityOTM buyer JOIN buyer.cartEntityOTMList WHERE buyer.id =: buyer_id", BuyerEntityOTM.class)
                .setParameter("buyer_id", buyerId)
                .getResultList()
                .stream()
                .flatMap(entity->entity.getCartEntityOTMList()
                        .stream())
                .collect(Collectors.toList());
    }
}