package fundamentals.P05.dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        int courses = (int) Math.ceil((double) numberOfPeople / capacity);

        //  int courses = numberOfPeople/capacity;
        //  if (numberOfPeople%capacity != 0){
        //      courses += 1;
        //  }
        System.out.println(courses);
    }
}
