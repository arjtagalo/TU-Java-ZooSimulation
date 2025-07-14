package com.example.ooput.utils;

import com.example.ooput.models.Product;

import java.util.Map;

public class Purchase {

    public static double calculateTotal(Map<Product, Integer> cart) {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.price() * quantity;
        }
        return total;
    }

    public static void printReceipt(Map<Product, Integer> cart) {
        System.out.println("\n--- 🧾 RECEIPT ---");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double lineTotal = product.price() * quantity;
            System.out.printf("%d x %s - P%.2f%n", quantity, product.name(), lineTotal);
        }
        double total = calculateTotal(cart);
        System.out.printf("TOTAL: P%.2f%n", total);
    }
}
