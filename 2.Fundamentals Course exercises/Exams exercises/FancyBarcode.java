package fundamentals.exams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "@[#]+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            String productGroup = "";
            if (matcher.find()) {
                String product = matcher.group("product");
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < product.length(); j++) {
                    if (Character.isDigit(product.charAt(j))) {
                        sb.append(product.charAt(j) - 48);
                    }
                }
                if (sb.toString().equals("")) {
                    productGroup = "00";
                } else {
                    productGroup = sb.toString();
                }


            } else {
                System.out.println("Invalid barcode");
                continue;
            }

            System.out.println("Product group: " + productGroup);
        }
    }
}
