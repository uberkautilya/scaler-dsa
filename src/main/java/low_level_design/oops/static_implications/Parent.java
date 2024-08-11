package low_level_design.oops.static_implications;

public class Parent {
    static void staticMethod() {
        System.out.println("Parent static method");
    }
    static void staticMethodAlsoInChild() {
        System.out.println("staticMethodAlsoInChild from Parent");
    }
    void normalMethod() {
        System.out.println("Normal method in Parent");
    }
}