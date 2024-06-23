package low_level_design_two.design_pattterns.creational.abstractfactory;

import low_level_design_two.design_pattterns.creational.abstractfactory.factories.Factory;

public class Client {
    public static void main(String[] args) {
        Platform platform = new Android();
        //Runtime polymorphism
        Factory factory = platform.createComponentFactory();
        factory
    }
}
