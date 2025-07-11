package com.example.ooput.modules;

import java.util.Scanner;

public class AdminModule {
    private final Scanner scanner;
    private final String USER = "admin";
    private final String PASS = "adminadmin";

    private boolean zooOpen = false;

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
        /*
            In progress
         */
    }

    private void accessHandlerModule() {
        /*
            In progress
         */
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

