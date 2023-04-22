package P02StacksAndQueues.Exercise;

import java.util.*;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plants = Integer.parseInt(scanner.nextLine());
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> plantStack = new ArrayDeque<>();
        ArrayDeque<Integer> survivedPlants = new ArrayDeque<>();
        int daysCount = 0;

        for (int i = 0; i < plants; i++) {
            int currentPlant = sequence[i];
            plantStack.addLast(currentPlant);

        }
        boolean isPlantDied = false;

        while (true) {

            int lastElement = plantStack.peekLast();

            while (plantStack.size() > 1) {


                int leftPlant = plantStack.pop();
                int rightPlant = plantStack.pop();

                // if (rightPlant == lastElement) {
//
                //     if (daysCount != 0 && leftPlant < rightPlant) {
                //         survivedPlants.offer(leftPlant);
                //         isPlantDied = true;
                //     }else{
                //         survivedPlants.addLast(rightPlant);
                //     }
                //     break;
                // }

                if (rightPlant > leftPlant) {

                    plantStack.push(leftPlant);

                    if (!survivedPlants.contains(leftPlant)) {
                        survivedPlants.offer(leftPlant);
                    }
                    isPlantDied = true;


                } else if (leftPlant > rightPlant) {

                    plantStack.push(rightPlant);

                    if (!survivedPlants.contains(leftPlant)) {

                        survivedPlants.offer(leftPlant);

                    }
                    if (!survivedPlants.contains(rightPlant)) {

                        survivedPlants.offer(rightPlant);
                    }
                }


                if (plantStack.size() == 1) {

                    break;
                }

            }
            if (!isPlantDied) {


                break;
            }

            daysCount++;
            isPlantDied = false;
            plantStack = survivedPlants;
            lastElement = plantStack.peekLast();


        }
        System.out.println(daysCount);


    }
}
