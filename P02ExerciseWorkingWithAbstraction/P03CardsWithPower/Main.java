package P02ExerciseWorkingWithAbstraction.P03CardsWithPower;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String rankString = scanner.nextLine();
        String suitString = scanner.nextLine();

        Card.Rank rank = Card.Rank.valueOf(rankString);
        Card.Suit suit = Card.Suit.valueOf(suitString);
        Card card = new Card(suit, rank);

        System.out.println("Card name: " + card.getName() + "; Card power: " + card.getPower());
    }

}
