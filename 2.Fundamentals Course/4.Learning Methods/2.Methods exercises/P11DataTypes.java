package fundamentals.P10.Methods.exercise;

import javax.xml.transform.stream.StreamResult;
import java.text.DecimalFormat;
import java.util.Scanner;

public class P11DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        DecimalFormat df = new DecimalFormat("0.00");


        switch (command) {
            case "int":
                int intNum = Integer.parseInt(scanner.nextLine());
                System.out.println(printResult(intNum));
                break;
            case "real":
                double floatNum = Double.parseDouble(scanner.nextLine());
                System.out.println(df.format(printResult(floatNum)));
                break;
            case "string":
                String inputLine = scanner.nextLine();
                System.out.println(printResult(inputLine));
                break;

        }

    }

    public static int printResult(int num) {
        return num * 2;
    }

    public static double printResult(double num) {
        return num * 1.5;
    }

    public static String printResult(String input) {
        return "$" + input + "$";
    }

}
