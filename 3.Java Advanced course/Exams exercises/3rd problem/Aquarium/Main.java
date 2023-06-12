package aquarium;

public class Main {
    public static void main(String[] args) {

        Aquarium aquarium = new Aquarium("Ocean", 5, 15);
        // Initialize Fish
        Fish fish = new Fish("Goldy", "gold", 4);
        // Print Fish
        System.out.println(fish.toString());

        //Fish: Goldy
        //Color: gold
        //Number of fins: 4

        // Add Fish
        aquarium.add(fish);

        // Find Fish
        System.out.println(aquarium.findFish("as"));

        // Get Fish in Pool
        System.out.println(aquarium.getFishInPool());

        // Remove Fish
        System.out.println(aquarium.remove("s")); // true

        Fish secondFish = new Fish("Dory", "blue", 2);
        Fish thirdFish = new Fish("Nemo", "orange", 5);

        // Add fish
        aquarium.add(secondFish);
        aquarium.add(thirdFish);

        // Print Aquarium report
        System.out.println(aquarium.report());

        //Aquarium Info:
        //Aquarium: Ocean ^ Size: 15
        //Fish: Dory
        //Color: blue
        //Number of fins: 2
        //Fish: Nemo
        //Color: orange
        //Number of fins: 5

    }
}
