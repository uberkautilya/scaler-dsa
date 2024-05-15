package low_level_design.oops.oops4.interfaces;

public class Client {
    public static void main(String[] args) {
        // Interfaces can act as custom types
        Runner human = new Human();
        human.run();

        Runner dog = new Dog();
        dog.run();

        System.out.println(Runner.x);
    }
}
