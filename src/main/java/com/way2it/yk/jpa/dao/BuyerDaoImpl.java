package com.way2it.yk.jpa.dao;

import com.way2it.yk.jpa.config.DatabaseConfig;
import com.way2it.yk.jpa.entity.BuyerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BuyerDaoImpl implements BuyerDao {

    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }

    @Override
    public List<BuyerEntity> getAllBuyers() {
        List<BuyerEntity> buyerEntities = new ArrayList<>();
        return entityManager.createQuery("SELECT buyer FROM BuyerEntity buyer ",BuyerEntity.class).getResultList();
    }

    @Override
    public void saveBuyer(BuyerEntity buyerEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(buyerEntity);
        transaction.commit();
    }

    @Override
    public Optional<BuyerEntity> getBuyerById(Integer buyerId) {
        return entityManager.createQuery("SELECT buyer FROM BuyerEntity buyer WHERE buyer.id =: buyerId", BuyerEntity.class)
                .setParameter("buyerId", buyerId)
                .getResultList()
                .stream()
                .findFirst();
    }


     @Override
    public void deleteBuyer(BuyerEntity buyerEntity) {
         EntityTransaction transaction = entityManager.getTransaction();
         transaction.begin();
         entityManager.remove(buyerEntity);
         transaction.commit();
    }
}