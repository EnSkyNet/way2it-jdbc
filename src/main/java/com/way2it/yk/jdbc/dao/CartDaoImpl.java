package com.way2it.yk.jdbc.dao;

import com.way2it.yk.jdbc.config.DatabaseConfig;
import com.way2it.yk.jdbc.entity.BuyerEntity;
import com.way2it.yk.jdbc.entity.CartEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private static Connection connection;

    static {
        try {
            connection = DatabaseConfig.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CartEntity> getAllCarts() {
        List<CartEntity> cartEntities = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cart");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int buyer_id = resultSet.getInt("buyer_id");
                int product_id = resultSet.getInt("product_id");
                int product_quantity = resultSet.getInt("product_quantity");
                String shop = resultSet.getString("shop");
                cartEntities.add(new CartEntity(id, buyer_id, product_id, product_quantity, shop));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartEntities;
    }

    @Override
    public void addCart(Integer buyerId, Integer productId, Integer product_quantity, String shop) {
        try (PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO cart (buyer_id, product_id,product_quantity,shop) VALUES (?,?,?,?)")) {
            statement.setInt(1, buyerId);
            statement.setInt(2, productId);
            statement.setInt(3, product_quantity);
            statement.setString(4, shop);
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CartEntity getCartById(Integer Id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM cart WHERE id = ?")) {
            statement.setInt(1, Id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int buyer_id = resultSet.getInt("buyer_id");
                int product_id = resultSet.getInt("product_id");
                int product_quantity = resultSet.getInt("product_quantity");
                String shop = resultSet.getString("shop");
                return new CartEntity(id, buyer_id, product_id, product_quantity, shop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCart(Integer productId, Integer product_quantity, Integer cartId) {
        try (PreparedStatement statement =
                     connection.prepareStatement("UPDATE cart SET product_id = ? ,product_quantity = ? WHERE id = ?")) {
            statement.setInt(1, productId);
            statement.setInt(2, product_quantity);
            statement.setInt(3, cartId);
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCart(Integer cartId) {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM cart WHERE id = ?")) {
            statement.setInt(1, cartId);
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
