package low_level_design.oops.static_implications;

public class StaticInheritance {

    public static void main(String[] args) {
        Child.staticMethod(); // Outputs: Parent static method
        //normalMethod of parent is not accessible as it is overridden in child. Here child's implementation is invoked
        ((Parent) new Child()).normalMethod();
        //Parent method can be invoked as only method hiding is applicable
        ((Parent) new Child()).staticMethodAlsoInChild();
    }
}
