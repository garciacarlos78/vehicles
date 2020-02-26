package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainF1 {

    public static void main(String[] args) throws Exception {

        // Ask the user for the plate, brand and color
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdueix la matrícula del cotxe");
        String plate = scanner.nextLine();
        System.out.println("Introdueix la marca del cotxe");
        String brand = scanner.nextLine();
        System.out.println("Introdueix el color del cotxe");
        String color = scanner.nextLine();

        // Create the car with the provided data
        Car myCar = new Car(plate, brand, color);

        // Ask the user for the brand and diameter of the back wheels
        System.out.println("Introdueix la marca de les rodes traseres");
        String bwBrand=scanner.nextLine();
        System.out.println("Introdueix el seu diàmetre");
        double bwDiameter=scanner.nextDouble();

        // Add back wheels to the car
        List<Wheel> backWheels = new ArrayList<>();
        backWheels.add(new Wheel(bwBrand,bwDiameter));
        backWheels.add(backWheels.get(0));
        myCar.addTwoWheels(backWheels);

        // Reset scanner
        scanner=new Scanner(System.in);

        // Ask the user for the brand and diameter of the back wheels
        System.out.println("Introdueix la marca de les rodes davanteres");
        String fwBrand=scanner.nextLine();
        System.out.println("Introdueix el seu diàmetre");
        double fwDiameter=scanner.nextDouble();

        // Add front wheels to the car
        List<Wheel> frontWheels = new ArrayList<>();
        frontWheels.add(new Wheel(fwBrand,fwDiameter));
        frontWheels.add(frontWheels.get(0));
        myCar.addTwoWheels(frontWheels);
    }
}
