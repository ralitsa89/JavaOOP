package P02ExerciseWorkingWithAbstraction.P05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Galaxy galaxy = readAndInitializeMatrix(scanner);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordsArr = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            Coords jediCoords = new Coords(jediCoordsArr[0], jediCoordsArr[1]);                                         //inline

            int[] evilCoords = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            moveEvilAndDestroyStars(galaxy, new Coords(evilCoords[0], evilCoords[1]));
            sum += moveJediAndCalculateStars(galaxy, jediCoords);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static long moveJediAndCalculateStars(Galaxy galaxy, Coords jediCoords) {

        long sum = 0;
        while (canJediStillMove(galaxy, jediCoords)) {
            if (galaxy.isInside(jediCoords)) {
                sum += galaxy.getValueAt(jediCoords);
            }
            jediCoords.row--;
            jediCoords.col++;
        }
        return sum;
    }

    private static boolean canJediStillMove(Galaxy galaxy, Coords coords) {
        return coords.row >= 0 && coords.col < galaxy.numCols;
    }

    private static boolean canEvilStillMove(Coords coords) {
        return coords.row >= 0 && coords.col >= 0;
    }

    private static void moveEvilAndDestroyStars(Galaxy galaxy, Coords evilCoords) {
        while (canEvilStillMove(evilCoords)) {
            if (galaxy.isInside(evilCoords)) {
                galaxy.setValueAt(evilCoords, 0);
            }
            evilCoords.row--;
            evilCoords.col--;
        }
    }

    static Galaxy readAndInitializeMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return new Galaxy(matrix);
    }
}
