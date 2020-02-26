package com.vehicles.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainF3 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // Ask the user if he wants a car or a bike
        String vehicle=new String();
        while (!vehicle.equalsIgnoreCase("cotxe") &&
            !vehicle.equalsIgnoreCase("moto")) {
            System.out.println("Introdueix el tipus de vehicle que vols crear (cotxe/moto):");
            vehicle = scanner.nextLine();
            // Reset scanner
            scanner = new Scanner(System.in);
        }

        boolean validPlate;
        String plate;
        do {
            System.out.println("Introdueix la matrícula del vehicle");
            plate = scanner.nextLine();
            validPlate = checkPlate(plate);
            if (!validPlate)
                System.out.println("Format de matrícula incorrecte. Ha de tenir 4 números i dues o tres lletres.");
        } while (!validPlate);

        System.out.println("Introdueix la marca del vehicle");
        String brand = scanner.nextLine();
        System.out.println("Introdueix el color del vehicle");
        String color = scanner.nextLine();

        // Create the vehicle with the provided data
        Vehicle myVehicle;
        if (vehicle.equalsIgnoreCase("cotxe")) myVehicle=new Car(plate, brand, color);
        else myVehicle=new Bike(plate, brand, color);

        // Ask the user for the brand and diameter of the back wheel(s)
        System.out.println("Introdueix la marca de la(es) roda(es) trasera(es)");
        String bwBrand = scanner.nextLine();
        double bwDiameter = 0;
        System.out.println("Introdueix el seu diàmetre");
        while (bwDiameter <= 0.4 || bwDiameter >= 4) {
            try {
                bwDiameter = scanner.nextDouble();
                if (bwDiameter <= 0.4 || bwDiameter >= 4) {
                    System.out.println("Diàmetre de la roda incorrecte, ha de ser superior a 0,4 i inferior a 4.");
                    System.out.printf("Torna a provar.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Format incorrecte del diàmetre, ha de ser un número sencer o decimal. Per exemple: 2,5");
                System.out.printf("Torna a provar.");
                scanner = new Scanner(System.in);
            }
        }

        // Create list of Wheel for the back wheels
        List<Wheel> backWheels = new ArrayList<>();
        backWheels.add(new Wheel(bwBrand, bwDiameter));
        // We need two wheels only if the vehicle is a car
        if (vehicle.equalsIgnoreCase("cotxe")) backWheels.add(backWheels.get(0));

        // Reset scanner
        scanner = new Scanner(System.in);

        // Ask the user for the brand and diameter of the front wheels
        System.out.println("Introdueix la marca de la(es) roda(es) davantera(es)");
        String fwBrand = scanner.nextLine();
        double fwDiameter = 0;
        System.out.println("Introdueix el seu diàmetre");
        while (fwDiameter <= 0.4 || fwDiameter >= 4) {
            try {
                fwDiameter = scanner.nextDouble();
                if (fwDiameter <= 0.4 || fwDiameter >= 4) {
                    System.out.println("Diàmetre de la roda incorrecte, ha de ser superior a 0,4 i inferior a 4.");
                    System.out.printf("Torna a provar.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Format incorrecte del diàmetre, ha de ser un número sencer o decimal. Per exemple: 2,5");
                System.out.printf("Torna a provar.");
                scanner = new Scanner(System.in);
            }
        }

        // Create list of Wheel for the front wheels
        List<Wheel> frontWheels = new ArrayList<>();
        frontWheels.add(new Wheel(fwBrand, fwDiameter));
        // We need two wheels only if the vehicle is a car
        if (vehicle.equalsIgnoreCase("cotxe")) frontWheels.add(frontWheels.get(0));

        // Add wheels to the vehicle
        myVehicle.addWheels(frontWheels, backWheels);
    }

    private static boolean checkPlate(String plate) {

        if (plate.length()<6 || plate.length()>7) return false;

        int numNumbers=0;
        int numLletres=0;

        for (int i=0;i<plate.length();i++){
            if (Character.isDigit(plate.charAt(i))) numNumbers++;
            else if (Character.isLetter(plate.charAt(i))) numLletres++;
            else return false;
        }

        if (numNumbers!=4) return false;
        if (numLletres!=2 && numLletres!=3) return false;

        return true;
    }
}
