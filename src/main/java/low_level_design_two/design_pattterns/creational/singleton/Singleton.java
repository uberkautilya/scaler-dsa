package low_level_design_two.design_pattterns.creational.singleton;

public class Singleton {
    //static field initialization is done by the main thread at the time of class loading
    private static final Singleton instance = new Singleton();
    String url;
    String name;

    private Singleton() {
        //Instance cannot be configured at runtime, if creation of object requires values which are available only at runtime
        this.url = "Value 101";
        this.name = "Name 101";
    }

    public static Singleton getInstance() {
        return instance;
    }
}
