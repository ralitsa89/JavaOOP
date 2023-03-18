package P11ExerciseSOLID.solid.products;

import java.util.List;

public class Printer {
//    public void printSum(List<Object> products) {
//        System.out.printf((SUM) + "%n", sum(products));
//    }
//
//    public void printAverage(List<Object> products) {
//        System.out.printf((AVERAGE) + "%n", average(products));
//    }

    public void print(String format, double amount){
        System.out.printf(format, amount);
    }
}
