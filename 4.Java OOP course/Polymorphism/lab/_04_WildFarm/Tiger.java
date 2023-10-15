package Polymorphism.lab._04_WildFarm;

import java.text.DecimalFormat;

public class Tiger extends Feline {


    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            System.out.println(this.getAnimalType() + "s are not eating that type of food!");

        } else {
            this.setFoodEaten(food.getQuantity() + this.getFoodEaten());
        }

    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s]",
                this.getAnimalType(), this.getAnimalName(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
