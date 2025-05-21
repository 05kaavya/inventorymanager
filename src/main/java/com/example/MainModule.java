package com.example;



import com.example.entity.Inventory;
import com.example.service.InventoryService;
import com.example.service.InventoryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryService service = new InventoryServiceImpl();

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Delete Item");
            System.out.println("3. View All Items");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addItem(service, sc);
                case 2 -> deleteItem(service, sc);
                case 3 -> viewAllItems(service);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addItem(InventoryService service, Scanner sc) {
        sc.nextLine(); // Consume newline
        System.out.print("Item Name: ");
        String name = sc.nextLine();
        System.out.print("Category: ");
        String category = sc.nextLine();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        Inventory item = new Inventory(name, category, quantity, price);
        System.out.println(service.addItem(item));
    }

    private static void deleteItem(InventoryService service, Scanner sc) {
        System.out.print("Enter Item ID to delete: ");
        int id = sc.nextInt();
        System.out.println(service.deleteItem(id));
    }

    private static void viewAllItems(InventoryService service) {
        List<Inventory> items = service.getAllItems();
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            items.forEach(System.out::println);
        }
    }
}

