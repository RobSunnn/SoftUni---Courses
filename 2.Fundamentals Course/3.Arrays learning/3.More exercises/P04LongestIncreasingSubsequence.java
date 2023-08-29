package More.Exercise.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbsArr.length ; i++) {
            int current = numbsArr[i];
            list.add(current);
            for (int j = 1; j < numbsArr.length ; j++) {

                int next = numbsArr[j + i];

                if (current < next) {

                 list.add(next);

                }else {

                    list.clear();
                    break;
                }



            }
        }
    }
}
