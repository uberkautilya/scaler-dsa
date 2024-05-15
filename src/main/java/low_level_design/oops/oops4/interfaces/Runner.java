package low_level_design.oops.oops4.interfaces;

public interface Runner {
    // All fields are constants: public static final - accessed through reference.x or Runner.x
    int x = 5;
    // All methods are public in interfaces for Java
    void run();

    // Default and static methods are also allowed
}
