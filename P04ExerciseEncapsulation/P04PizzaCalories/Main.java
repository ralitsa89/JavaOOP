package P04ExerciseEncapsulation.P04PizzaCalories;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String[] pizzaData = scanner.nextLine().split(" ");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);


        String[] doughData = scanner.nextLine().split(" ");
        String flourType = doughData[1];
        String backingTechnique = doughData[2];
        double doughWeigh = Double.parseDouble(doughData[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            Dough dough = new Dough(flourType, backingTechnique, doughWeigh);
            pizza.setDough(dough);

            String toppingData = scanner.nextLine();
            while (!"END".equals(toppingData)) {
                String[] toppingInfo = toppingData.split(" ");
                String toppingType = toppingInfo[1];
                double toppingWeigh = Double.parseDouble(toppingInfo[2]);

                Topping topping = new Topping(toppingType, toppingWeigh);

                pizza.addTopping(topping);
                toppingData = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
