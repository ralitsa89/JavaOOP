package P06ExerciseInheritance.P06Animals;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        // the main package suppose to be called "animal" for a judge check to be 100/100

        String animalType = scanner.nextLine();
        while (!"Beast!".equals(animalType)) {
            String[] animalInfo = scanner.nextLine().split(" ");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            try {
                switch (animalType) {
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            animalType = scanner.nextLine();
        }
    }
}
