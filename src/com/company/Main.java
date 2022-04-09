package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Truck[] trucks = {
                new Truck(1, "Renault Magnum", "", "base"),
                new Truck(2, "Volvo FH12", "", "base"),
                new Truck(3, "DAF XF", "", "base")};

        Driver[] drivers = {
                new Driver("driver-1", "Ulansky"),
                new Driver("driver-2", "Altyha"),
                new Driver("driver-3", "Zakha")};

        print(trucks);
        print(drivers);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while (true) {
            System.out.println("Choose one of the trucks: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            Driver.getInfo(trucks[input - 1]);
            ServiceImpl service = new ServiceImpl();
            getInstruction();
            String action = scanner.nextLine();
            if (action.equals("1")) {
                service.changeDriver(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("2")) {
                service.startDriving(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("3")) {
                service.startRepair(trucks[input - 1], drivers[input - 1]);
            }
            print(trucks);
            print(drivers);
        }
    }

    public static void print(Truck[] trucks) {
        System.out.println("~~~~~~~~~~~~ * TRUCKS * ~~~~~~~~~~~~");
        System.out.println(" # |    Bus    |  Driver  |  State");
        System.out.println("---+-----------+----------+---------");
        for (int j = 0; j < trucks.length; j++) {
            System.out.println(trucks[j]);
        }
    }

    public static void print(Driver[] drivers) {
        System.out.println("~~~~~~~~~~ * DRIVERS * ~~~~~~~~~~~~~");
        System.out.println("     #    |   Driver   |   Truck      ");
        System.out.println("----------+------------+------------");
        for (int j = 0; j < drivers.length; j++) {
            System.out.println(drivers[j]);
        }
    }

    public static void getInstruction() {
        System.out.println("Press to 1 to change driver");
        System.out.println("Press to 2 to start driving");
        System.out.println("Press to 3 to start repair");
    }
}