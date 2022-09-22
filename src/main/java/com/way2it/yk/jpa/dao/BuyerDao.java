package com.way2it.yk.jpa.dao;

import com.way2it.yk.jpa.entity.BuyerEntity;

import java.util.List;
import java.util.Optional;

public interface BuyerDao {
    List<BuyerEntity> getAllBuyers();

    Optional<BuyerEntity> getBuyerById(Integer buyerId);

    void saveBuyer(BuyerEntity buyerEntity);
    void deleteBuyer(BuyerEntity buyerEntity);
}
