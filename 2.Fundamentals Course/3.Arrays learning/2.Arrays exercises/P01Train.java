package fundamentals.P08.Arrays.exercise;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumPeople = 0;
        int[] people = new int[n];

        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(scanner.nextLine());
            sumPeople += people[i];
            System.out.print(people[i] + " ");

        }
        System.out.println();
        System.out.print(sumPeople);
    }
}
