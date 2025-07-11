package com.example.ooput.modules;

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
            System.out.print("Choose an Option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nWould you like to feed? (yes/no): ");
                    String answer = scanner.nextLine().trim().toLowerCase();

                    if(answer == "yes") {
                        System.out.println("\n --- Choose Animal to Feed ---");



                    }
                    break;
                case 2:
                    System.out.println();
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

            switch (choice){
                case 1:
                    System.out.println("Sick Animals:");
                    //list sick animals
                    break;
                case 2:
                    System.out.println("Healed Animals:");
                    //list healed animals
                    break;
                case 3:
                    System.out.println(); // get vet.lecture();
                    break;
                case 4:
                    System.out.println(); // get vet.heal();
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Try Again.");

            }



        }
    }

    private void visitShops() {
        while (true) {
            System.out.println("\n --- Zoo Shop --- ");
            System.out.println("Available Products:");
            //for(int i = 0; i <= ) //List Items
            System.out.print("Choose an Option: ");
            int choice = scanner.nextInt();



        }
    }


}


