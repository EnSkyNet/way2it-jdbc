package com.way2it.yk.mapping.one_to_one.dao;

import com.way2it.yk.mapping.one_to_one.config.HibernateSessionConfiguration;
import com.way2it.yk.mapping.one_to_one.entity.BuyerEntityOTO;
import com.way2it.yk.mapping.one_to_one.entity.CartEntityOTO;
import com.way2it.yk.mapping.one_to_one.entity.OrderEntityOTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class OrderDaoOTOImpl implements OrderDaoOTO {
    public static final Logger logger = LogManager.getLogger(Logger.class);
    private static SessionFactory sessionFactory = HibernateSessionConfiguration.getSessionFactory();

    @Override
    public void deleteOrder(OrderEntityOTO orderEntityOTO) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(orderEntityOTO);
            transaction.commit();
        }
    }

    @Override
    public void saveOrder(OrderEntityOTO orderEntityOTO) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            logger.info(orderEntityOTO);
            session.save(orderEntityOTO);
            transaction.commit();
        }
    }

    @Override
    public Optional<OrderEntityOTO> findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT orders FROM OrderEntityOTO orders WHERE orders.id =: ordersId" , OrderEntityOTO.class)
                    .setParameter("ordersId", id)
                    .getResultList()
                    .stream()
                    .findFirst();
        }
    }

    @Override
    public List<OrderEntityOTO> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT orders FROM OrderEntityOTO orders", OrderEntityOTO.class).getResultList();
        }
    }
}
