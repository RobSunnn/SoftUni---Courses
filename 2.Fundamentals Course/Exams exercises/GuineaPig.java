package fundamentals.exams;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double food = Double.parseDouble(scanner.nextLine()) * 1000;
        double hay = Double.parseDouble(scanner.nextLine()) * 1000;
        double cover = Double.parseDouble(scanner.nextLine()) * 1000;
        double pigsWeight = Double.parseDouble(scanner.nextLine()) * 1000;

        boolean mustGoToStore = false;

        for (int days = 1; days <= 30; days++) {

            food -= 300;

            if (days % 2 == 0) {

                hay -= food * 0.05;
            }

            if (days % 3 == 0) {

                cover -= pigsWeight / 3;
            }

            if (food <= 0 || hay <= 0 || cover <= 0) {

                mustGoToStore = true;
                break;
            }

        }

        if (mustGoToStore) {

            System.out.println("Merry must go to the pet store!");
        } else {

            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n", food / 1000, hay / 1000, cover / 1000);
        }
    }
}
