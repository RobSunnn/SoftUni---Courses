package fundamentals.P15.TextProcessing.exercise;


import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigNumber = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int multiplier = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        char[] numbers = bigNumber.toCharArray();
        int resultToSave = 0;

        if (bigNumber.isEmpty()) {
            bigNumber = "0";
        }
        if (multiplier == 0) {
            System.out.println(0);
            return;
        }


        for (int i = numbers.length - 1; i >= 0; i--) {
            char currentNum = (char) (numbers[i] - 48);

            int result = currentNum * multiplier;
            result += resultToSave;
            sb.append(result % 10);
            resultToSave = result / 10;

        }
        if (resultToSave > 0) {
            sb.append(resultToSave);
        }


        System.out.println(sb.reverse());
    }
}
