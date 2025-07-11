package com.example.ooput.modules;

import com.example.ooput.models.*;
import com.example.ooput.models.animal.Feline;
import com.example.ooput.models.people.Handler;
import com.example.ooput.models.people.Manager;
import com.example.ooput.models.people.Vendor;
import com.example.ooput.models.people.Veterinarian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminModule {
    private final Scanner scanner;
    private final String USER = "admin";
    private final String PASS = "adminadmin";

    private boolean zooOpen = false;

    private final List<People> staffList = new ArrayList<>();

    public AdminModule(Scanner scanner) {
        this.scanner = scanner;
    }

    public void login() {
        System.out.println("\n=== Welcome to the Zoo Admin Console ===");
        System.out.println("Please log in.");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(USER) && password.equals(PASS)) {
            System.out.println("Login successful. Welcome!");
            showAdminMenu();
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void showAdminMenu() {
        while (true) {
            System.out.println("\n========== 🦁 ZOO ADMIN MAIN MENU ==========");
            System.out.println("1. Setup Zoo Staff");
            System.out.println("2. Access Handler Module");
            System.out.println("3. Open Zoo to Visitors");
            System.out.println("4. Close Zoo to Visitors");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> setupZooStaff();
                case "2" -> accessHandlerModule();
                case "3" -> openZoo();
                case "4" -> closeZoo();
                case "5" -> {
                    System.out.println("Exiting admin console...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void setupZooStaff() {
        System.out.println("\n--- Zoo Setup ---\n");

        System.out.print("Enter your name, Manager: ");
        String managerName = scanner.nextLine();
        Manager manager = new Manager(managerName);
        staffList.add(manager);

        System.out.print("\nEnter Veterinarian's name: ");
        String vetName = scanner.nextLine();
        Veterinarian vet = new Veterinarian(vetName);
        staffList.add(vet);

        System.out.print("\nEnter Handler for Pachyderm Enclosure: ");
        String handler1 = scanner.nextLine();
        Handler pachydermHandler = new Handler(handler1);
        staffList.add(pachydermHandler);

        System.out.print("\nEnter Handler for Feline Enclosure: ");
        String handler2 = scanner.nextLine();
        Handler felineHandler = new Handler(handler2);
        staffList.add(felineHandler);

        System.out.print("\nEnter Handler for Bird Enclosure: ");
        String handler3 = scanner.nextLine();
        Handler birdHandler = new Handler(handler3);
        staffList.add(birdHandler);

        System.out.print("\nEnter Vendor for Ticket Shop: ");
        String vendor1 = scanner.nextLine();
        Vendor ticketVendor = new Vendor(vendor1);
        staffList.add(ticketVendor);

        System.out.print("\nEnter Vendor for Shop: ");
        String vendor2 = scanner.nextLine();
        Vendor shopVendor = new Vendor(vendor2);
        staffList.add(shopVendor);

        System.out.println("\nZoo staff setup complete.");
    }


    private void accessHandlerModule() {
        System.out.print("Enter your name (Handler): ");
        String name = scanner.nextLine();

        Handler handler = new Handler(name);
        System.out.println("\nWelcome, Handler " + handler.getName() + "!\n");

        List<Animal> assignedAnimals = new ArrayList<>();
        assignedAnimals.add(new Feline("Mufasa", "Feline Enclosure"));
        assignedAnimals.add(new Feline("Simba", "Feline Enclosure"));

        while (true) {
            System.out.println("--- Animal Duty Menu ---");
            System.out.println("Animals assigned to you:");
            for (int i = 0; i < assignedAnimals.size(); i++) {
                System.out.println((i + 1) + ". " + assignedAnimals.get(i).name);
            }

            System.out.print("\nChoose animal number to interact with (0 to exit): ");
            int animalChoice = Integer.parseInt(scanner.nextLine());

            if (animalChoice == 0) {
                System.out.println("Finished duties for the day.");
                break;
            }

            if (animalChoice < 1 || animalChoice > assignedAnimals.size()) {
                System.out.println("Invalid animal number.\n");
                continue;
            }

            Animal selectedAnimal = assignedAnimals.get(animalChoice - 1);
            System.out.println("Choose action:");
            System.out.println("1. Feed " + selectedAnimal.name);
            System.out.println("2. Exercise " + selectedAnimal.name);
            System.out.println("3. Examine " + selectedAnimal.name + " to Vet");
            System.out.print("Choose an option: ");

            int action = Integer.parseInt(scanner.nextLine());

            switch (action) {
                case 1 -> handler.feed();
                case 2 -> handler.exercise();
                case 3 -> {
                    handler.examine();
                    System.out.println("Sending to Hospital...");
                    String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    System.out.println(selectedAnimal.name + " admitted at " + time + "\n");
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void openZoo() {
        if (zooOpen) {
            /*
                In progress
             */
        } else {
            /*
                In progress
             */
        }
    }

    private void closeZoo() {
        /*
            In progress
         */
    }
}

