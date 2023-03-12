package P07InterfacesAndAbstraction.P06Ferrari;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String driverName = scanner.nextLine();

        Car ferrari = new Ferrari(driverName);

        System.out.println(ferrari.toString());
    }
}
