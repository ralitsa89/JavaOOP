package P13ExerciseReflectionAndAnnotation.blackBoxInteger;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(in);

        String input = scanner.nextLine();
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field innerValue = clazz.getDeclaredField("innerValue");
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());

        while (!input.equals("END")) {
            String commandName = input.split("_")[0];
            int number = Integer.parseInt(input.split("_")[1]);

            switch (commandName) {
                case "add":
                    executeCommand(blackBoxInt, innerValue, number, "add", methods);
                    break;
                case "subtract":
                    executeCommand(blackBoxInt, innerValue, number, "subtract", methods);
                    break;
                case "divide":
                    executeCommand(blackBoxInt, innerValue, number, "divide", methods);
                    break;
                case "multiply":
                    executeCommand(blackBoxInt, innerValue, number, "multiply", methods);
                    break;
                case "rightShift":
                    executeCommand(blackBoxInt, innerValue, number, "rightShift", methods);
                    break;
                case "leftShift":
                    executeCommand(blackBoxInt, innerValue, number, "leftShift", methods);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void executeCommand(BlackBoxInt blackBoxInt,
                                       Field innerValue, int number, String command, List<Method> methods)
            throws IllegalAccessException, InvocationTargetException {

        Method currentMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(command)) {
                currentMethod = method;
                break;
            }
        }
        currentMethod.setAccessible(true);
        currentMethod.invoke(blackBoxInt, number);
        innerValue.setAccessible(true);
        System.out.println(innerValue.get(blackBoxInt));
    }
}
