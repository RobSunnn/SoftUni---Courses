import java.util.Scanner;

public class vacationBookList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pagesCount = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int daysCount = Integer.parseInt(scanner.nextLine());

        int timeNeeded = pagesCount / pagesPerHour;
        int timeNeededPerDay = timeNeeded / daysCount;

        System.out.println(timeNeededPerDay);
    }
}
