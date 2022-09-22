package com.way2it.yk.mapping.one_to_one.dao;

import com.way2it.yk.mapping.one_to_one.entity.OrderEntityOTO;

import java.util.List;
import java.util.Optional;

public interface OrderDaoOTO {
    void deleteOrder(OrderEntityOTO orderEntityOTO);
    void saveOrder(OrderEntityOTO orderEntityOTO);
    Optional<OrderEntityOTO> findById(Integer id);
    List<OrderEntityOTO> findAll();
}
