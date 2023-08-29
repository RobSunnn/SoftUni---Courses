import java.util.Scanner;

public class projectCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String architectName = scanner.nextLine();
        int projectCount = Integer.parseInt(scanner.nextLine());

        int projectTime = projectCount * 3;

        System.out.printf("The architect %s will need %d hours to complete %d project/s."
                , architectName, projectTime, projectCount);
    }
}
