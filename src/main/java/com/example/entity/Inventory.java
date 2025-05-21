package com.example.entity;

public class Inventory {
    private int itemId;
    private String itemName;
    private String category;
    private int quantity;
    private double price;

    public Inventory() {}

    public Inventory(String itemName, String category, int quantity, double price) {
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public Inventory(int itemId, String itemName, String category, int quantity, double price) {
        this(itemName, category, quantity, price);
        this.itemId = itemId;
    }

    // Getters and Setters
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return itemId + " | " + itemName + " | " + category + " | " + quantity + " | " + price;
    }
}

    

