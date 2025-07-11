package com.example.ooput;

import com.example.ooput.modules.AdminModule;
import com.example.ooput.modules.ZooModule;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminModule adminModule = new AdminModule(scanner);
        ZooModule zooModule = new ZooModule();

        while (true) {
            System.out.println("\nZoo Simulation Main Menu:");
            System.out.println("1. Admin Login");
            System.out.println("2. Ticketing");
            System.out.println("3. Enter Zoo");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> adminModule.login();
//                case 2 -> ; // Ticketing
                case 3 -> zooModule.showZooMenu(); // Enter Zoo
//                case 4 -> ; // Exit
                default -> System.out.println("Invalid option.");
            }
        }
    }
}