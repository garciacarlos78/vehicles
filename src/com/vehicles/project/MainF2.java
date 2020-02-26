package com.vehicles.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainF2 {

    public static void main(String[] args) throws Exception {

        // Ask the user for the plate, brand and color
        Scanner scanner = new Scanner(System.in);

        boolean validPlate;
        String plate;
        do {
            System.out.println("Introdueix la matrícula del cotxe");
            plate = scanner.nextLine();
            validPlate = checkPlate(plate);
            if (!validPlate)
                System.out.println("Format de matrícula incorrecte. Ha de tenir 4 números i dues o tres lletres.");
        } while (!validPlate);

        System.out.println("Introdueix la marca del cotxe");
        String brand = scanner.nextLine();
        System.out.println("Introdueix el color del cotxe");
        String color = scanner.nextLine();

        // Create the car with the provided data
        Car myCar = new Car(plate, brand, color);

        // Ask the user for the brand and diameter of the back wheels

        System.out.println("Introdueix la marca de les rodes traseres");
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


        // Add back wheels to the car
        List<Wheel> backWheels = new ArrayList<>();
        backWheels.add(new Wheel(bwBrand, bwDiameter));
        backWheels.add(backWheels.get(0));
        myCar.addTwoWheels(backWheels);

        // Reset scanner
        scanner = new Scanner(System.in);

        // Ask the user for the brand and diameter of the back wheels
        System.out.println("Introdueix la marca de les rodes davanteres");
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

        // Add front wheels to the car
        List<Wheel> frontWheels = new ArrayList<>();
        frontWheels.add(new Wheel(fwBrand, fwDiameter));
        frontWheels.add(frontWheels.get(0));
        myCar.addTwoWheels(frontWheels);
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
