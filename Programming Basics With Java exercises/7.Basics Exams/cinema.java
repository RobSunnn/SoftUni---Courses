package basic.exams;

import java.util.Scanner;

public class cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seats = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int peopleCount = 0;
        int totalPrice = 0;


        while (!input.equals("Movie time!")) {
            int people = Integer.parseInt(input);
            peopleCount += people;

            if (peopleCount > seats) {
                System.out.println("The cinema is full.");
                System.out.printf("Cinema income - %d lv.", totalPrice);
                break;
            }

            int price = people * 5;

            if (people % 3 == 0) {
                price = price - 5;
            }
            totalPrice += price;


            input = scanner.nextLine();
        }

        if (input.equals("Movie time!")) {
            System.out.printf("There are %d seats left in the cinema.%n", seats - peopleCount);
            System.out.printf("Cinema income - %d lv.", totalPrice);
        }


    }
}
