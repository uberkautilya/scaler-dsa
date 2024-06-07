package low_level_design_two.solid_principles;

import low_level_design_two.solid_principles.interfaces.Flyable;
import low_level_design_two.solid_principles.interfaces.implementations.FlyLowBehavior;

public class Client {
    public static void main(String[] args) {
        System.out.println("\nPenguin");
        Bird penguin = new Penguin();
        penguin.eat();

        System.out.println("\nEagle");
        Flyable eagle = new Eagle();
        eagle.fly();

        System.out.println("\nSparrow");
        Flyable sparrow = new Sparrow();
        sparrow.fly();

        System.out.println("\nPigeon");
        Flyable pigeon = new Pigeon(new FlyLowBehavior());
        pigeon.fly();
    }
}
