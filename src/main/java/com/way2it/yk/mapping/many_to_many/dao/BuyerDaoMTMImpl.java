package com.way2it.yk.mapping.many_to_many.dao;

import com.way2it.yk.mapping.many_to_many.config.DatabaseConfig;
import com.way2it.yk.mapping.many_to_many.config.HibernateSessionConfiguration;
import com.way2it.yk.mapping.many_to_many.entity.BuyerEntityMTM;
import com.way2it.yk.mapping.many_to_many.entity.CartEntityMTM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BuyerDaoMTMImpl implements BuyerDaoMTM {
    public static final Logger logger = LogManager.getLogger(Logger.class);

    private static SessionFactory sessionFactory = HibernateSessionConfiguration.getSessionFactory();
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }

    @Override
    public List<BuyerEntityMTM> getAllBuyers() {
        try (Session session = sessionFactory.openSession()) {
            List<BuyerEntityMTM> buyerEntities = new ArrayList<>();
            return session.createQuery("SELECT buyer FROM BuyerEntityMTM buyer JOIN FETCH buyer.salerEntityMTMList ", BuyerEntityMTM.class).getResultList();
        }
    }

    @Override
    public void saveBuyer(BuyerEntityMTM buyerEntityMTM) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(buyerEntityMTM);
            transaction.commit();
        }
    }
    @Override
    public Optional<BuyerEntityMTM> getBuyerById(Integer buyerId) {
        return entityManager.createQuery("SELECT buyer FROM BuyerEntityMTM buyer WHERE buyer.id =: buyerId", BuyerEntityMTM.class)
                .setParameter("buyerId", buyerId)
                .getResultList()
                .stream()
                .findFirst();
    }


     @Override
    public void deleteBuyer(BuyerEntityMTM buyerEntityMTM) {
         try (Session session = sessionFactory.openSession()) {
             Transaction transaction = session.beginTransaction();
             session.remove(buyerEntityMTM);
             transaction.commit();
         }
    }

    @Override
    public List<CartEntityMTM> getCartByBuyerId(Integer buyerId) {
        return entityManager.createQuery("SELECT buyer FROM BuyerEntityMTM buyer JOIN buyer.cartEntityOTOList WHERE buyer.id =: buyer_id", BuyerEntityMTM.class)
                .setParameter("buyer_id", buyerId)
                .getResultList()
                .stream()
                .flatMap(entity->entity.getCartEntityMTMList()
                        .stream())
                .collect(Collectors.toList());
    }
}