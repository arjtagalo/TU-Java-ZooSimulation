package com.example.ooput;

import com.example.ooput.models.people.Veterinarian;
import com.example.ooput.modules.AdminModule;
import com.example.ooput.modules.TicketingModule;
import com.example.ooput.modules.ZooModule;

import java.util.Scanner;

import static com.example.ooput.utils.ZooAccessUtil.isZooOpen;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminModule adminModule = new AdminModule(scanner);
        TicketingModule ticketingModule = new TicketingModule(scanner);


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
                case 2 -> {
                    if (!isZooOpen(adminModule, "Ticketing")) break;
                    handleTicketPurchaseAndEntry(ticketingModule);
                }
                case 3 -> {
                    if (!isZooOpen(adminModule, "Zoo access")) break;

                    Veterinarian vet = adminModule.getVeterinarian(); // need to setup staff first to get vet name
                    if (vet == null) {
                        System.out.println("Please complete staff setup in Admin first.");
                        break;
                    }
                    ZooModule zooModule = new ZooModule(scanner, ticketingModule, vet);
                    zooModule.ticketVerify();
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void handleTicketPurchaseAndEntry(TicketingModule ticketingModule) {
        ticketingModule.purchaseTicket();

    }

}