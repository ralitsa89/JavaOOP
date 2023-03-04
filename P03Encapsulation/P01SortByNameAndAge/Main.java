package P03Encapsulation.P01SortByNameAndAge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

            Person personToAdd = new Person(firstName, lastName, age);
            people.add(personToAdd);
        }

        Collections.sort(people, (firstPerson, secondPerson) -> {
            int comparisonResult = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (comparisonResult != 0) {
                return comparisonResult;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
