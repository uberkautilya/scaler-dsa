package low_level_design.advanced_concepts.generics.bounds;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Poo"));
        animals.add(new Animal("Jupitor"));

        AnimalUtility.printAnimalNames(animals);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Tobby"));
        dogs.add(new Dog("Titto"));

        AnimalUtility.printNames(dogs);
    }
}
