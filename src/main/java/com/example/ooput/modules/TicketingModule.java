package com.example.ooput.modules;

import com.example.ooput.models.shop.Ticket;
import com.example.ooput.utils.TicketGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicketingModule {
    private final Scanner scanner;
    private final Map<String, Ticket> ticketMap = new HashMap<>();

    public TicketingModule(Scanner scanner) {
        this.scanner = scanner;
    }

    public String purchaseTicket() {
        System.out.println("\n=== 🎟️ WELCOME TO THE ZOO TICKET SHOP ===\n");

        System.out.println("Here's what you can experience in the zoo:");
        System.out.println("Visit Animal Enclosures (Elephant, Lion, Owl)");
        System.out.println("Buy snacks and drinks from our Shops");
        System.out.println("Listen to science lectures at the Hospital");
        System.out.println("Buy fun gifts at our Gift Shop\n");

        System.out.print("Would you like to buy a ticket? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (!confirm.equals("yes")) return null;

        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age input. Cancelling transaction.");
            return null;
        }

        String type;
        double price;

        if (age <= 5) {
            type = "CHILD";
            price = 0.00;
        } else if (age <= 17) {
            type = "STUDENT";
            price = 75.00;
        } else if (age <= 59) {
            type = "ADULT";
            price = 150.00;
        } else {
            type = "SENIOR";
            price = 50.00;
        }

        System.out.println("\nYou qualify for a " + type + " ticket.");
        System.out.printf("Ticket Price: P%.2f%n", price);

        System.out.print("\nProceed with purchase? (yes/no): ");
        String proceed = scanner.nextLine().trim().toLowerCase();
        if (!proceed.equals("yes")) return null;

        String code = TicketGenerator.generateCode();
        Ticket ticket = new Ticket(name, age, type, price, code);
        ticketMap.put(code, ticket);

        System.out.println("\nTicket purchased!");
        System.out.println("Your ticket code is: " + code);
        System.out.println("\n[Ticket added to system]");

        return code;
    }

    public boolean validateTicket(String code) {
        return ticketMap.containsKey(code);
    }

    public Ticket getTicket(String code) {
        return ticketMap.get(code);
    }
}

