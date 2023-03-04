package P03Encapsulation.P02SalaryIncrease;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(in);
        int numberOfPeople = Integer.parseInt(reader.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = reader.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            Person personToAdd = new Person(firstName, lastName, age, salary);
            people.add(personToAdd);
        }

        double bonus = Double.parseDouble(reader.nextLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}
