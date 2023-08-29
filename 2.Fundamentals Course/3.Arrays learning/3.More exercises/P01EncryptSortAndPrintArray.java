package More.Exercise.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] words = new String[n];
        int[] wordToNumber=new int[n];

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            words[i] = word;
        }

        for (int i = 0; i < words.length ; i++) {
            char[] charArr=words[i].toCharArray();
            int sum = 0;
            for (int j = 0; j <charArr.length ; j++) {
                char current=charArr[j];
                if (current=='a'||current=='A'||current=='e'||current=='E'||current=='o'
                        ||current=='O'||current=='i'||current=='I'||current=='u'||current=='U'){
                    sum+= current*charArr.length;
                }else {
                    sum+=current / charArr.length;
                }

            }
            wordToNumber[i]=sum;
        }
        List<Integer> toPrint=new ArrayList<>();
        for (int num:wordToNumber){
            toPrint.add(num);
        }
        Collections.sort(toPrint);
        for (int num:toPrint){
            System.out.println(num);
        }
    }
}
