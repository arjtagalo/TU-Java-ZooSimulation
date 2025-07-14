package com.example.ooput.modules;

import com.example.ooput.models.Animal;
import com.example.ooput.models.Product;
import com.example.ooput.models.animal.Bird;
import com.example.ooput.models.animal.Feline;
import com.example.ooput.models.animal.Pachyderm;
import com.example.ooput.models.people.Veterinarian;
import com.example.ooput.utils.Hospital;
import com.example.ooput.utils.Purchase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ZooModule {
    private final Scanner scanner;
    private final TicketingModule ticketingModule;
    private final Veterinarian veterinarian;

    public ZooModule(Scanner scanner, TicketingModule ticketingModule, Veterinarian veterinarian){
        this.scanner = scanner;
        this.ticketingModule = ticketingModule;
        this.veterinarian = veterinarian;
    }

    public void ticketVerify() {
        System.out.println("\n --- \uD83C\uDF9F\uFE0F Zoo Entry Point ---");
        System.out.print("Enter Ticket Code: ");
        String ticketCode = scanner.nextLine();

        if (ticketingModule.validateTicket(ticketCode.toUpperCase())) {
            System.out.println("Ticket Valid! Welcome to the Zoo.");
            showZooMenu();
        } else {
            System.out.println("Invalid Ticket. Access Denied.");
        }
    }

    public void showZooMenu(){

        while (true){
            System.out.println("\n----- Welcome to the Zoo -----");
            System.out.println("What would you like to do?");
            System.out.println("1. Visit Enclosure");
            System.out.println("2. Visit Hospital");
            System.out.println("3. Visit Shop");
            System.out.println("4. Leave Zoo");
            System.out.print("Choose an Option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> visitEnclosure();
                case 2 -> visitHospital();
                case 3 -> visitShops();
                case 4 -> {
                    System.out.println("Thank You, Come Again!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }

        }

    }

    private void visitEnclosure() {
        while (true) {
            System.out.println("\n --- Choose Enclosure --- ");
            System.out.println("1. Pachyderm");
            System.out.println("2. Feline");
            System.out.println("3. Birds");
            System.out.println("4. Return to Main Menu");
            System.out.print("Choose an Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) return;

            System.out.print("\nWould you like to feed? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (!answer.equals("yes")) continue;

            //connected to the private class feedAnimalist
            switch (choice) {
                case 1 -> feedAnimalList(Pachyderm.getAllPachyderm());
                case 2 -> feedAnimalList(Feline.getAllFeline());
                case 3 -> feedAnimalList(Bird.getAllBird());
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void visitHospital() {
        while (true) {
            System.out.println("\n --- Zoo Hospital Monitor --- ");
            System.out.println("1. View Sick Animals");
            System.out.println("2. View Healed Animals");
            System.out.println("3. Attend Science Lecture");
            System.out.println("4. Heal Animals (Veterinarian)");
            System.out.println("5. Exit Hospital");
            System.out.print("Choose an Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    List<Animal> sick = Hospital.getSickAnimals();
                    if (sick.isEmpty()) {
                        System.out.println("No sick animals.");
                    } else {
                        System.out.println("Sick Animals:");
                        sick.forEach(a -> System.out.println("- " + a.name));
                    }
                }
                case 2 -> {
                    List<Animal> healed = Hospital.getHealedAnimals();
                    if (healed.isEmpty()) {
                        System.out.println("No animals have been healed yet.");
                    } else {
                        System.out.println("Healed Animals:");
                        healed.forEach(a -> System.out.println("- " + a.name));
                    }
                }
                case 3 -> {
                    System.out.println("\nLecture by Veterinarian " + veterinarian.getName() + ":");
                    veterinarian.lecture();
                }
                case 4 -> Hospital.healAllAnimals(veterinarian.getName());
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Try Again.");
            }
        }
    }

    private void visitShops() {
        List<Product> shopItems = List.of(
                new Product("Plush Elephant", 150.00),
                new Product("Zoo Map", 25.00),
                new Product("Safari Hat", 80.00),
                new Product("Animal Stickers", 30.00),
                new Product("T-Shirt", 120.00)
        );

        Map<Product, Integer> cart = new HashMap<>();

        while (true) {
            System.out.println("\n--- 🛍️ Zoo Gift Shop ---");
            System.out.println("Available Products:");
            for (int i = 0; i < shopItems.size(); i++) {
                Product p = shopItems.get(i);
                System.out.printf("%d. %s - P%.2f%n", i + 1, p.name(), p.price());
            }
            System.out.println((shopItems.size() + 1) + ". Checkout");
            System.out.println((shopItems.size() + 2) + ". Cancel and Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == shopItems.size() + 1) break; // Checkout
            if (choice == shopItems.size() + 2) {
                System.out.println("Exiting shop. No items purchased.");
                return;
            }

            if (choice < 1 || choice > shopItems.size()) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Product selected = shopItems.get(choice - 1);

            System.out.print("Enter quantity for " + selected.name() + ": ");
            int qty = scanner.nextInt();
            scanner.nextLine();

            cart.put(selected, cart.getOrDefault(selected, 0) + qty);
            System.out.println(qty + " x " + selected.name() + " added to cart.");
        }

        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        Purchase.printReceipt(cart);

        // Simulate payment
        System.out.print("\nProceed with payment? (yes/no): ");
        String payConfirm = scanner.nextLine().trim().toLowerCase();
        if (payConfirm.equals("yes")) {
            System.out.println("Payment accepted. Thank you for your purchase!");
        } else {
            System.out.println("Purchase cancelled. Your cart has been cleared.");
        }
    }


    //for feeding the animals
    private <T extends Animal> void feedAnimalList(List<T> animals) {
        System.out.println("\n --- Choose Animal to Feed ---");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i).name);
        }

        System.out.print("Enter choice: ");
        int feedChoice = scanner.nextInt();
        scanner.nextLine();

        if (feedChoice > 0 && feedChoice <= animals.size()) {
            T selected = animals.get(feedChoice - 1);
            selected.eat();
            selected.makeSound();
        } else {
            System.out.println("Invalid selection.");
        }
    }


}


