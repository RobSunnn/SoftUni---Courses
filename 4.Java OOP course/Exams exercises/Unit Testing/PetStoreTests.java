package petStore;

import org.junit.Assert;
import org.junit.Test;


public class PetStoreTests {

    @Test(expected = IllegalArgumentException.class)
    public void isAnimalAddedWhenNull() {
        PetStore petStore = new PetStore();
        Animal animal = null;
        petStore.addAnimal(animal);
    }

    @Test
    public void isAnimalAdded() {
        PetStore petStore = new PetStore();
        Animal animal = new Animal("CHIHUAHUA", 3, 1000.0);
        petStore.addAnimal(animal);
        Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void isFindAnimalsByKgWorks() {
        PetStore petStore = new PetStore();
        Animal animal = new Animal("CHIHUAHUA", 3, 1000.0);
        Animal animal2 = new Animal("CHIHUAHUA", 3, 1000.0);
        Animal animal3 = new Animal("CHIHUAHUA", 3, 1000.0);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(3, petStore.findAllAnimalsWithMaxKilograms(2).size());
    }

    @Test
    public void isFindMostExpensiveWorks() {
        PetStore petStore = new PetStore();
        Animal animal = new Animal("CHIHUAHUA", 3, 1000.0);
        Animal animal2 = new Animal("CHIHUAHUA", 3, 10000.0);
        Animal animal3 = new Animal("CHIHUAHUA", 3, 100000.0);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(animal3, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void isFindBySpeciesWorks() {
        PetStore petStore = new PetStore();
        Animal animal = new Animal("CHIHUAHUA", 3, 1000.0);
        Animal animal2 = new Animal("PITBULL", 3, 1000.0);
        Animal animal3 = new Animal("DOGO", 3, 1000.0);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(1, petStore.findAllAnimalBySpecie("CHIHUAHUA").size());
    }
}

