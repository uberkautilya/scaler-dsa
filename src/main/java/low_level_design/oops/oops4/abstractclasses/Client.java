package low_level_design.oops.oops4.abstractclasses;

public class Client {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
        animal.display();
    }
}
