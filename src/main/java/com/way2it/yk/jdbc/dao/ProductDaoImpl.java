package com.way2it.yk.jdbc.dao;

import com.way2it.yk.jdbc.config.DatabaseConfig;
import com.way2it.yk.jdbc.entity.CartEntity;
import com.way2it.yk.jdbc.entity.ProductEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static Connection connection;

    static {
        try {
            connection = DatabaseConfig.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> productEntities = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                productEntities.add(new ProductEntity(id, name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productEntities;
    }


    @Override
    public void addProduct(String name, Integer price) {
        try (PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO product (name, price) VALUES (?,?)")) {
            statement.setString(1, name);
            statement.setInt(2, price);
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductEntity getProductById(Integer Id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = ?")) {
            statement.setInt(1, Id);
            ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    return new ProductEntity(id, name, price);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public void updateProduct(String name, Integer price, Integer productId) {
        try (PreparedStatement statement =
                     connection.prepareStatement("UPDATE product SET name = ? ,price = ? WHERE id = ?")) {
            statement.setString(1, name);
            statement.setInt(2, price);
            statement.setInt(3, productId);
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Integer productId) {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM product WHERE id = ?")) {
            statement.setInt(1, productId);
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
