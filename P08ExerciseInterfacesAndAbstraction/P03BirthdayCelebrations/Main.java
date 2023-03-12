package P08ExerciseInterfacesAndAbstraction.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String input = scanner.nextLine();

        List<Birthable> thingsWithBirthday = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputParts = input.split(" ");
            String typeToCreate = inputParts[0];
            switch (typeToCreate) {
                case "Citizen":
                    String citizenName = inputParts[1];
                    int age = Integer.parseInt(inputParts[2]);
                    String id = inputParts[3];
                    String citizenBirtDate = inputParts[4];
                    Citizen citizen = new Citizen(citizenName, age, id, citizenBirtDate);
                    thingsWithBirthday.add(citizen);
                    break;
                case "Pet":
                    String petName = inputParts[1];
                    String petBirtDate = inputParts[2];
                    Pet pet = new Pet(petName, petBirtDate);
                    thingsWithBirthday.add(pet);
                    break;
                case "Robot":
                    break;

            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();

        for (Birthable birthable : thingsWithBirthday) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
