package P07InterfacesAndAbstraction.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String line = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!line.equals("End")) {
            String[] tokens = line.split(" ");

            Identifiable identifiable;
            if (tokens.length == 2) {
                identifiable = new Robot(tokens[0], tokens[1]);
            } else {
                identifiable = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }
            identifiables.add(identifiable);

            line = scanner.nextLine();
        }
        String fakeIds = scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(fakeIds)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
