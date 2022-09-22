package com.way2it.yk.mapping.many_to_many.dao;

import com.way2it.yk.mapping.many_to_many.entity.OrderEntityMTM;

import java.util.List;
import java.util.Optional;

public interface OrderDaoMTM {
    void deleteOrder(OrderEntityMTM orderEntityMTM);
    void saveOrder(OrderEntityMTM orderEntityMTM);
    Optional<OrderEntityMTM> findById(Integer id);
    List<OrderEntityMTM> findAll();
}
