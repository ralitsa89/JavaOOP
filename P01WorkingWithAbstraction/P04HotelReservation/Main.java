package P01WorkingWithAbstraction.P04HotelReservation;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String[] input = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(input[0]);
        int numOfDays =Integer.parseInt(input[1]);
         Season season = Season.valueOf(input[2]);
         Discount discount = Discount.valueOf(input[3]);

        double finalPrice = PriceCalculator.calculatePrice(pricePerDay, numOfDays,season, discount);

        System.out.printf("%.2f", finalPrice);
    }
}
