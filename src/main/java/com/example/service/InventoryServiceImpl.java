package com.example.service;



import com.example.entity.Inventory;
import com.example.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private Connection conn;

    public InventoryServiceImpl() {
        conn = DBConnectionUtil.getConnection();
    }

    @Override
    public String addItem(Inventory item) {
        String sql = "INSERT INTO inventory(itemName, category, quantity, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getItemName());
            stmt.setString(2, item.getCategory());
            stmt.setInt(3, item.getQuantity());
            stmt.setDouble(4, item.getPrice());
            int rows = stmt.executeUpdate();
            return rows > 0 ? "Item added successfully." : "Failed to add item.";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String deleteItem(int itemId) {
        String sql = "DELETE FROM inventory WHERE itemId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, itemId);
            int rows = stmt.executeUpdate();
            return rows > 0 ? "Item deleted successfully." : "Item not found.";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public List<Inventory> getAllItems() {
        List<Inventory> list = new ArrayList<>();
        String sql = "SELECT * FROM inventory";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Inventory(
                    rs.getInt("itemId"),
                    rs.getString("itemName"),
                    rs.getString("category"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
}

