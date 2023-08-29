package fundamentals.P12.Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input=scanner.nextLine().split(" ");
        int bombNumber=Integer.parseInt(input[0]);
        int bombPower=Integer.parseInt(input[1]);
        int sum=0;

        while(numbers.contains(bombNumber)){

            int indexBomb=numbers.indexOf(bombNumber);
            int left=Math.max(0,indexBomb-bombPower);
            int right=Math.min(numbers.size()-1,indexBomb+bombPower);

            for (int i = right; i >=left ; i--) {
                numbers.remove(i);
            }
        }
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
