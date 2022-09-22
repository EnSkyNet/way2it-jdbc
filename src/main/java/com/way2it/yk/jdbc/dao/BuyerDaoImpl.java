package com.way2it.yk.jdbc.dao;

import com.way2it.yk.jdbc.config.DatabaseConfig;
import com.way2it.yk.jdbc.entity.BuyerEntity;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerDaoImpl implements BuyerDao {

    private static Connection connection;

    static {
        try {
            connection = DatabaseConfig.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BuyerEntity> getAllBuyers() {
        List<BuyerEntity> buyerEntities = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM buyer");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int money = resultSet.getInt("money");
                buyerEntities.add(new BuyerEntity(id, name, money));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyerEntities;
    }

    @Override
    public void addBuyer(String name, Integer money) {
        try (PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO buyer (name, money) VALUES (?,?)")) {
            statement.setString(1, name);
            statement.setInt(2, money);
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BuyerEntity getBuyerById(Integer buyerId) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM buyer WHERE id = ?")) {
            statement.setInt(1, buyerId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int money = resultSet.getInt("money");
                return new BuyerEntity(id, name, money);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateBuyer(String name, Integer money, Integer buyerId) {
        try (PreparedStatement statement =
                     connection.prepareStatement("UPDATE buyer SET name = ? , money = ? WHERE id = ?")) {
            statement.setString(1, name);
            statement.setInt(2, money);
            statement.setInt(3, buyerId);
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBuyer(Integer buyerId) {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM buyer WHERE id = ?")) {
            statement.setInt(1, buyerId);
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}