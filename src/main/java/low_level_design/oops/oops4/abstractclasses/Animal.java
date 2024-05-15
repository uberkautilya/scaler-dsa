package low_level_design.oops.oops4.abstractclasses;

public abstract class Animal {

    // Unlike interfaces where all attributes are public static void,
    // Abstract classes allow all the flexibility
    private int id;
    void display() {
        System.out.println("Animal concrete method");
    }
    // Abstract methods
    abstract void eat();
}
