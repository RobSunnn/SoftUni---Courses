package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PetStoreTests {
    //TODO: Test Garage class

    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp() {
        petStore = new PetStore();
        animal = new Animal("Skoda", 198, 599.45);

        petStore.addAnimal(animal);
    }

    @Test(expected = IllegalArgumentException.class)  // Tested N1
    public void addCarShouldThrow() {
        Animal carNull = null;

        petStore.addAnimal(carNull);
    }

    @Test
    public void getCOuntShouldReturnOne() { // Tested N3
        int actualCount = petStore.getCount();
        int expectedCount = 1;
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getCarsShouldReturnCorrectList() { //Not
        List<Animal> expected = new ArrayList<>();
        expected.add(animal);

        List<Animal> actualCars = petStore.getAnimals();

        assertEquals(expected, actualCars);
    }

    @Test
    public void findCarsMaxSPeedAboveShouldReturnCorrectList() { //Tested N2
        Animal car2 = new Animal("Car2", 10, 24);
        Animal car3 = new Animal("Car3", 199, 24);
        Animal car4 = new Animal("Car4", 192, 22);
        petStore.addAnimal(car2);
        petStore.addAnimal(car3);
        petStore.addAnimal(car4);

        List<Animal> expectedCars = new ArrayList<>(Arrays.asList(animal,car3, car4));
        List<Animal> actualCars = petStore.findAllAnimalsWithMaxKilograms(190);

        assertEquals(expectedCars,actualCars);
    }


    @Test
    public void getMOstExpensiveCarShudlReturnCorrectCar(){ //Tested N4
        Animal car2 = new Animal("Car2", 10, 24);
        Animal car3 = new Animal("Car3", 199, 24);
        Animal car4 = new Animal("Car4", 192, 22);
        petStore.addAnimal(car2);
        petStore.addAnimal(car3);
        petStore.addAnimal(car4);


        Animal actualResult = petStore.getTheMostExpensiveAnimal();
        assertEquals(animal,actualResult);
    }

    @Test
    public void findAllCarsByBrandShouldReturnCorrectList(){
        Animal car2 = new Animal("Skoda", 10, 24);
        Animal car3 = new Animal("Car3", 199, 24);
        Animal car4 = new Animal("Car4", 192, 22);
        petStore.addAnimal(car2);
        petStore.addAnimal(car3);
        petStore.addAnimal(car4);


        List<Animal> expectedCars = new ArrayList<>(Arrays.asList(animal,car2));
        List<Animal> actualCars = petStore.findAllAnimalBySpecie("Skoda");

        assertEquals(expectedCars,actualCars);
    }
}
