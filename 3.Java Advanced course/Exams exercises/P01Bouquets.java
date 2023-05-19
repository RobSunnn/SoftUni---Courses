package Exams;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(",\\s+");
        String[] secondArr = scanner.nextLine().split(",\\s+");

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        ArrayDeque<Integer> flowersLeft = new ArrayDeque<>();

        int bouquetsCount = 0;

        for (int i = 0; i < firstArr.length; i++) {

            tulipsStack.push(Integer.parseInt(firstArr[i]));
        }
        for (int i = 0; i < secondArr.length; i++) {

            daffodils.offer(Integer.parseInt(secondArr[i]));

        }

        while (tulipsStack.size() > 0 && daffodils.size() > 0) {

            int tulip = tulipsStack.pop();

            int daffodil = daffodils.poll();

            int result = tulip + daffodil;

            if (result == 15) {

                bouquetsCount++;
            } else if (result > 15) {

                tulip -= 2;
                tulipsStack.addFirst(tulip);
                daffodils.addFirst(daffodil);

            } else {

                flowersLeft.offerLast(result);
            }

        }


        if (tulipsStack.size() > 0) {
            int sum = 0;
            while (tulipsStack.size() > 0) {

                int flower = tulipsStack.pop();
                sum += flower;

            }
            sum = sum / 15;
            bouquetsCount += sum;
        }

        if (daffodils.size() > 0) {
            int sum = 0;
            while (daffodils.size() > 0) {
                int flower = daffodils.poll();
                sum += flower;

            }

            sum = sum / 15;
            bouquetsCount += sum;
        }
        if (flowersLeft.size() > 0) {

            int sum = 0;
            while (flowersLeft.size() > 0) {
                int flower = flowersLeft.poll();
                sum += flower;
            }
            sum = sum / 15;
            bouquetsCount += sum;
        }

        if (bouquetsCount >= 5) {

            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquetsCount);
        } else {

            System.out.printf("You failed... You need more %d bouquets.%n", 5 - bouquetsCount);
        }
    }
}
