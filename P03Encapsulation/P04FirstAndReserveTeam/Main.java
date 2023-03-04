package P03Encapsulation.P04FirstAndReserveTeam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(in);
        int numberOfPeople = Integer.parseInt(reader.nextLine());
        Team team = new Team("Black Eagles");

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = reader.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            Person personToAdd = new Person(firstName, lastName, age, salary);
            team.addPlayer(personToAdd);
        }

        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players%n", team.getReserveTeam().size());
    }
}
