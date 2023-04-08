package fundamentals.exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        int shots = 0;

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);

            if (index > targets.size() - 1) {
                command = scanner.nextLine();
                continue;
            }
            shots++;
            int currentValue = targets.get(index);

            if (index <= targets.size() - 1) {
                for (int i = 0; i < targets.size(); i++) {
                    targets.set(index, -1);

                    if (targets.get(i) > currentValue) {

                        if (targets.get(i) == -1) {
                            continue;
                        }
                        int targetValue = targets.get(i);
                        targets.set(i, targetValue - currentValue);
                    } else if (targets.get(i) <= currentValue) {

                        if (targets.get(i) == -1) {
                            continue;
                        }
                        int targetValue = targets.get(i);
                        targets.set(i, currentValue + targetValue);
                    }

                }

                command = scanner.nextLine();
            }
        }
        String list = targets.toString();
        String listToPrint = String.join(" ", list);
        System.out.printf("Shot targets: %d -> %s", shots, listToPrint.replaceAll("[\\[\\],]", ""));
    }
}
