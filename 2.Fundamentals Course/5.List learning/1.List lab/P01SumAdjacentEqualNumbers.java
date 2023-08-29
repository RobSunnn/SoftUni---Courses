package fundamentals.P11.Lists.lab;

import java.io.DataOutput;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        DecimalFormat df = new DecimalFormat("0.##");


        for (int i = 0; i < numbsList.size() - 1; i++) {
            double firstNum = numbsList.get(i);
            double secondNum = numbsList.get(i + 1);
            if (firstNum == secondNum) {
                numbsList.set(i, numbsList.get(i) + numbsList.get(i + 1));
                numbsList.remove(numbsList.get(i + 1));
                i = -1;
            }

        }

        for (double num : numbsList) {

            System.out.print(df.format(num) + " ");
        }
    }
}
