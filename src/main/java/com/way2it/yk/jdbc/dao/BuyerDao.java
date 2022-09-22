package com.way2it.yk.jdbc.dao;

import com.way2it.yk.jdbc.entity.BuyerEntity;

import java.util.List;

public interface BuyerDao {
    List<BuyerEntity> getAllBuyers();

    void addBuyer(String name, Integer money);

    BuyerEntity getBuyerById(Integer buyerId);

    void updateBuyer(String name, Integer money, Integer buyerId);
    void deleteBuyer(Integer buyerId);
}
