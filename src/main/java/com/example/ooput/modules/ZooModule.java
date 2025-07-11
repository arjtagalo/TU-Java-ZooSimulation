package com.example.ooput.modules;

import com.example.ooput.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooModule {
    private final Scanner scanner;


    public ZooModule(){
        scanner = new Scanner(System.in);
    }

//    public void ticketVerify(){
//        try{
//            System.out.println("\n --- Zoo Entry Point ---");
//            System.out.print("Enter Ticket Code: ");
//            String ticketCode = scanner.nextLine();
//
//            //if()
//
//        } catch (){
//
//        }
//    }

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
                    System.out.println("Exiting admin console...");
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
            System.out.println("2. Birds");
            System.out.print("Choose an Option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nWould you like to feed? (yes/no): ");
                    String answer = scanner.nextLine().trim().toLowerCase();

                    if(answer == "yes") {
                        System.out.println("\n --- Choose Animal to Feed ---");

                    }
            }
        }
    }

    private void visitHospital() {
    }

    private void visitShops() {
    }


}

