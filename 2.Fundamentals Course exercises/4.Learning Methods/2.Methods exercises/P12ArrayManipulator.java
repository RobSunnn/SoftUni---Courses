package fundamentals.P10.Methods.exercise;

import java.util.*;


public class P12ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputLine = input.split(" ");
            String command = inputLine[0];

            switch (command) {

                case "exchange":
                    int index = Integer.parseInt(inputLine[1]);

                    if (!isIndexValid(index, numberArray)) {

                        System.out.println("Invalid index");
                        break;

                    } else {

                        splitArrayMethod(index, numberArray);
                    }


                    break;

                case "max":
                    String evenOrOdd = inputLine[1];

                    if (evenOrOdd.equals("odd")) {
                        if (returnsMaxOddIndex(numberArray) < 0) {
                            System.out.println("No matches");
                            break;

                        } else {

                            System.out.println(returnsMaxOddIndex(numberArray));
                        }


                    } else if (evenOrOdd.equals("even")) {

                        if (returnsMaxEvenIndex(numberArray) < 0) {

                            System.out.println("No matches");
                            break;

                        } else {

                            System.out.println(returnsMaxEvenIndex(numberArray));
                        }

                    }

                    break;

                case "min":
                    String evenOrOddNum = inputLine[1];

                    if (evenOrOddNum.equals("odd")) {

                        if (returnsMinOddIndex(numberArray) > numberArray.length) {

                            System.out.println("No matches");
                            break;

                        } else {

                            System.out.println(returnsMinOddIndex(numberArray));
                        }


                    } else if (evenOrOddNum.equals("even")) {
                        if (returnsMinEvenIndex(numberArray) > numberArray.length) {

                            System.out.println("No matches");
                            break;

                        } else {

                            System.out.println(returnsMinEvenIndex(numberArray));
                        }

                    }

                    break;
                case "first":
                    int count = Integer.parseInt(inputLine[1]);
                    String evenOrOddCount = inputLine[2];

                    if (count > numberArray.length) {
                        System.out.println("Invalid count");
                        break;
                    }

                    if (evenOrOddCount.equals("even")) {

                        if (returnsCountOfEvenNumbs(count, numberArray).isEmpty()) {

                            System.out.println("[]");
                        } else {

                            System.out.println(returnsCountOfEvenNumbs(count, numberArray));
                        }


                    } else if (evenOrOddCount.equals("odd")) {

                        if (returnsCountOfOddNumbs(count, numberArray).isEmpty()) {

                            System.out.println("[]");

                        } else {
                            System.out.println(returnsCountOfOddNumbs(count, numberArray));
                        }

                    }


                    break;

                case "last":
                    int countLast = Integer.parseInt(inputLine[1]);
                    String evenOrOddLast = inputLine[2];

                    if (countLast > numberArray.length) {
                        System.out.println("Invalid count");
                        break;
                    }

                    if (evenOrOddLast.equals("even")) {

                        if (returnsLastCountOfEvenNumbs(countLast, numberArray).isEmpty()) {

                            System.out.println("[]");

                        } else {
                            System.out.println(returnsLastCountOfEvenNumbs(countLast, numberArray));
                        }


                    } else if (evenOrOddLast.equals("odd")) {

                        if (returnsLastCountOfOddNumbs(countLast, numberArray).isEmpty()) {

                            System.out.println("[]");
                        } else {

                            System.out.println(returnsLastCountOfOddNumbs(countLast, numberArray));
                        }

                    }
                    break;
            }


            input = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numberArray));


    }

    public static void splitArrayMethod(int n, int[] arr) {
        if (isIndexValid(n, arr)) {
            int lengthOfFirst = n + 1;
            int lengthSecond = arr.length - 1 - n;
            int[] firstPart = new int[lengthOfFirst];
            int[] secondPart = new int[lengthSecond];

            for (int i = 0; i < firstPart.length; i++) {
                firstPart[i] = arr[i];
            }
            for (int i = 0; i < secondPart.length; i++) {
                secondPart[i] = arr[n + 1 + i];
            }

            int[] newArr = new int[lengthOfFirst + lengthSecond];

            for (int i = 0; i < lengthSecond; i++) {
                newArr[i] = secondPart[i];
            }
            int index = 0;
            for (int i = lengthSecond; i < newArr.length; i++) {
                newArr[i] = firstPart[index];
                index++;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = newArr[i];
            }
        }

    }

    public static boolean isIndexValid(int n, int[] arr) {
        return n >= 0 && n <= arr.length - 1;
    }

    public static int returnsMaxOddIndex(int[] arr) {
        int indexOfMaxOdd = Integer.MIN_VALUE;
        int maxOddNum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];
            if (currentNum % 2 == 1) {
                if (currentNum >= maxOddNum) {
                    maxOddNum = currentNum;
                    indexOfMaxOdd = i;
                }
            }
        }
        return indexOfMaxOdd;
    }

    public static int returnsMaxEvenIndex(int[] arr) {
        int indexOfMaxEven = Integer.MIN_VALUE;
        int maxEvenNum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];

            if (currentNum % 2 == 0) {
                if (currentNum >= maxEvenNum) {

                    maxEvenNum = currentNum;
                    indexOfMaxEven = i;
                }
            }

        }
        return indexOfMaxEven;
    }

    public static int returnsMinOddIndex(int[] arr) {
        int indexOfMinOdd = Integer.MAX_VALUE;
        int minOddNum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];

            if (currentNum % 2 == 1) {

                if (currentNum <= minOddNum) {
                    minOddNum = currentNum;
                    indexOfMinOdd = i;
                }
            }
        }
        return indexOfMinOdd;

    }

    public static int returnsMinEvenIndex(int[] arr) {
        int indexOfMinEven = Integer.MAX_VALUE;
        int minEvenNum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];

            if (currentNum % 2 == 0) {

                if (currentNum <= minEvenNum) {
                    minEvenNum = currentNum;
                    indexOfMinEven = i;
                }
            }
        }
        return indexOfMinEven;
    }

    public static List returnsCountOfEvenNumbs(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int countNumbs = 0;

        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];

            if (currentNum % 2 == 0) {
                list.add(currentNum);
                countNumbs++;
            }
            if (countNumbs == n) {
                break;
            }
        }
        return list;
    }

    public static List returnsCountOfOddNumbs(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int countNumbs = 0;

        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];

            if (currentNum % 2 == 1) {
                list.add(currentNum);
                countNumbs++;
            }
            if (countNumbs == n) {
                break;
            }
        }
        return list;
    }

    public static List<Integer> returnsLastCountOfEvenNumbs(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int countNumbs = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            int currentNum = arr[i];

            if (currentNum % 2 == 0) {
                list.add(currentNum);
                countNumbs++;
            }
            if (countNumbs == n) {
                break;
            }

        }
        Collections.reverse(list);
        return list;
    }

    public static List<Integer> returnsLastCountOfOddNumbs(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int countNumbs = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            int currentNum = arr[i];

            if (currentNum % 2 == 1) {
                list.add(currentNum);
                countNumbs++;
            }
            if (countNumbs == n) {
                break;
            }

        }
        Collections.reverse(list);
        return list;
    }

}
