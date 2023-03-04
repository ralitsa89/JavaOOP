package P02ExerciseWorkingWithAbstraction.P04TrafficLights;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String trafficLightsLine = scanner.nextLine();
        String[] trafficLightsAsStrings = trafficLightsLine.split("\\s+");

        TrafficLights[] trafficLights = new TrafficLights[trafficLightsAsStrings.length];
        for (int i = 0; i < trafficLightsAsStrings.length; i++) {
            String s = trafficLightsAsStrings[i];
            TrafficLights.Signal signal = TrafficLights.Signal.valueOf(s);
            trafficLights[i] = new TrafficLights(signal);
        }

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            updateTrafficLights(trafficLights);
            printTrafficLights(trafficLights);
        }
    }

    private static void printTrafficLights(TrafficLights[] trafficLights) {
        for (TrafficLights trafficLight : trafficLights) {
            System.out.print(trafficLight.getSignal() + " ");
        }
        System.out.println();
    }

    private static void updateTrafficLights(TrafficLights[] trafficLights) {
        for (TrafficLights trafficLight : trafficLights) {
            trafficLight.update();
        }
    }
}
