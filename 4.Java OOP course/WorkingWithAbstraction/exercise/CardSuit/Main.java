package WorkingWithAbstraction.exercise.CardSuit;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        System.out.printf("Card name: %s of %s; Card power: %d",
                CardRanks.valueOf(cardRank), CardSuits.valueOf(cardSuit),
                CardRanks.getPower(CardRanks.valueOf(cardRank), CardSuits.valueOf(cardSuit)));

    }
}
