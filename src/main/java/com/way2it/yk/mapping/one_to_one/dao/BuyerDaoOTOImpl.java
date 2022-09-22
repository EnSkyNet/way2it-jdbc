package com.way2it.yk.mapping.one_to_one.dao;

import com.way2it.yk.mapping.one_to_one.config.DatabaseConfig;
import com.way2it.yk.mapping.one_to_one.config.HibernateSessionConfiguration;
import com.way2it.yk.mapping.one_to_one.entity.BuyerEntityOTO;
import com.way2it.yk.mapping.one_to_one.entity.CartEntityOTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BuyerDaoOTOImpl implements BuyerDaoOTO {
    private static SessionFactory sessionFactory = HibernateSessionConfiguration.getSessionFactory();
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }

    @Override
    public List<BuyerEntityOTO> getAllBuyers() {
        try (Session session = sessionFactory.openSession()) {
            return entityManager.createQuery("SELECT buyer FROM BuyerEntityOTO buyer ", BuyerEntityOTO.class).getResultList();
        }
    }

    /*@Override
    public void saveBuyer(BuyerEntityOTO buyerEntityOTO) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(buyerEntityOTO);
        transaction.commit();
    }*/
    @Override
    public void saveBuyer(BuyerEntityOTO buyerEntityOTO) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(buyerEntityOTO);
            transaction.commit();
        }
    }
    @Override
    public Optional<BuyerEntityOTO> getBuyerById(Integer buyerId) {
        return entityManager.createQuery("SELECT buyer FROM BuyerEntityOTO buyer WHERE buyer.id =: buyerId", BuyerEntityOTO.class)
                .setParameter("buyerId", buyerId)
                .getResultList()
                .stream()
                .findFirst();
    }


     @Override
    public void deleteBuyer(BuyerEntityOTO buyerEntityOTO) {
         EntityTransaction transaction = entityManager.getTransaction();
         transaction.begin();
         entityManager.remove(buyerEntityOTO);
         transaction.commit();
    }

    @Override
    public List<CartEntityOTO> getCartByBuyerId(Integer buyerId) {
        return entityManager.createQuery("SELECT buyer FROM BuyerEntityOTO buyer JOIN buyer.cartEntityOTOList WHERE buyer.id =: buyer_id", BuyerEntityOTO.class)
                .setParameter("buyer_id", buyerId)
                .getResultList()
                .stream()
                .flatMap(entity->entity.getCartEntityOTOList()
                        .stream())
                .collect(Collectors.toList());
    }
}