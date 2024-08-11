package low_level_design.oops.static_implications;

class Child extends Parent {
    // No static method with the same signature

    static void staticMethodAlsoInChild() {
        System.out.println("staticMethodAlsoInChild from Chile");
    }

    @Override
    void normalMethod() {
        System.out.println("Normal method in Child class");
    }
}