package basic.exams;


import java.util.Scanner;

public class tournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double daysOfTournament = Integer.parseInt(scanner.nextLine());
        double winCount = 0;
        double lostCount = 0;
        double money = 0;
        double moneyPerDay = 0;
        double winsCountDay = 0;
        double losesCountDay = 0;

        for (int i = 1; i <= daysOfTournament; i++) {
            String sport = scanner.nextLine();

            while (!sport.equals("Finish")) {
                String result = scanner.nextLine();
                if (result.equals("win")) {
                    winsCountDay++;
                    winCount++;
                    moneyPerDay += 20;
                } else {
                    losesCountDay++;
                    lostCount++;
                }
                sport = scanner.nextLine();
            }

            if (winsCountDay > losesCountDay) {
                moneyPerDay = moneyPerDay + moneyPerDay * 10 / 100;
            }
            money += moneyPerDay;
            moneyPerDay = 0;
            winsCountDay = 0;
            losesCountDay = 0;
        }
        if (winCount > lostCount) {
            money = money + money * 20 / 100;
        }
        if (winCount > lostCount) {
            System.out.printf("You won the tournament! Total raised money: %.2f", money);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", money);
        }

    }
}



