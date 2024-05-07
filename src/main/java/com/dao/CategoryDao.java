package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutility.DBUtility;
import com.model.Category;

public class CategoryDao {

  
    public static boolean insertCategory(Category category) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "INSERT INTO Category (name, description) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, category.getName());
                statement.setString(2, category.getDescription());
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public static boolean updateCategory(Category category) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "UPDATE Category SET name = ?, description = ? WHERE categoryId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, category.getName());
                statement.setString(2, category.getDescription());
                statement.setLong(3, category.getCategoryId());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public static boolean deleteCategory(long categoryId) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "DELETE FROM Category WHERE categoryId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, categoryId);
                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public static Category getCategoryById(long categoryId) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "SELECT * FROM Category WHERE categoryId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, categoryId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String description = resultSet.getString("description");
                        return new Category(categoryId, name, description);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "SELECT * FROM Category";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        long categoryId = resultSet.getLong("categoryId");
                        String name = resultSet.getString("name");
                        String description = resultSet.getString("description");
                        categories.add(new Category(categoryId, name, description));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
