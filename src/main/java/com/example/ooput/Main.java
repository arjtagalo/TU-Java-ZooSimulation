package com.example.ooput;

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
                case 2 -> {
                    if (!isZooOpen(adminModule, "Ticketing")) break;
                    handleTicketPurchaseAndEntry(ticketingModule, zooModule);
                }
                case 3 -> {
                    if (!isZooOpen(adminModule, "Zoo access")) break;
                    zooModule.showZooMenu();
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void handleTicketPurchaseAndEntry(TicketingModule ticketingModule, ZooModule zooModule) {
        String ticketCode = ticketingModule.purchaseTicket();
        if (ticketCode != null) {
            if (ticketingModule.validateTicket(ticketCode)) {
                /**
                 * @arjtagalo, once ticketVerify was implemented zoo module
                 * that should be the default module user will be redirected assuming they purchased a valid ticket from ticketingModule
                 * - @leadsoftengrlalusin
                 */
                zooModule.showZooMenu();
//                zooModule.ticketVerify();
            } else {
                System.out.println("Ticket validation failed.");
            }
        }
    }

}