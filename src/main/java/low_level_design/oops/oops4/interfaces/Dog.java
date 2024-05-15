package low_level_design.oops.oops4.interfaces;

public class Dog implements  Runner{
    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    public void bark() {
        System.out.println("Dog is barking");
    }
}
