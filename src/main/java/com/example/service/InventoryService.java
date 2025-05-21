package com.example.service;



import com.example.entity.Inventory;
import java.util.List;

public interface InventoryService {
    String addItem(Inventory item);
    String deleteItem(int itemId);
    List<Inventory> getAllItems();
}

