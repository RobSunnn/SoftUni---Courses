package InterfacesAndAbstraction.lab._01_CarShop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        Car seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Car audi = new Audi("ALLROAD", "Green", 300, "Germany", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {

        System.out.println(car.toString());

    }
}
