package low_level_design.advanced_concepts.generics.bounds;

import java.util.List;

public class AnimalUtility {
    public static void printAnimalNames(List<Animal> animals) {
        for (Animal a : animals) {
            System.out.println("a.name = " + a.name);
        }
        animals.add(new Dog("Doggo"));
    }

    //If T type information isn't required as part of the method body, it could have been ?
    public static <T extends Animal> void printNames(List<T> animals) {
        for (T animal : animals) {
            System.out.println(animal);
        }
//        animals.add(new Dog("Torrino"));
    }
}
