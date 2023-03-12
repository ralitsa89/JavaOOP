package P08ExerciseInterfacesAndAbstraction.P04FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            Buyer buyer;
            if (parts.length == 3) {
                String rebelName = parts[0];
                int rebelAge = Integer.parseInt(parts[1]);
                String group = parts[2];
                buyer = new Rebel(rebelName, rebelAge, group);
                buyers.put(rebelName, buyer);
            } else if (parts.length == 4){
                String citizenName = parts[0];
                int citizenAge = Integer.parseInt(parts[1]);
                String id = parts[2];
                String birthDate = parts[3];
                buyer = new Citizen(citizenName,citizenAge,id, birthDate);
                buyers.put(citizenName, buyer);
            }
        }
        String input = scanner.nextLine();
        while (!"End".equals(input)){
            Buyer buyer = buyers.get(input);

            if (buyer != null){
                buyer.buyFood();
            }
            input = scanner.nextLine();
        }
        int sum = buyers.values().stream().mapToInt(Buyer::getFood).sum();

        System.out.println(sum);
    }
}
