package low_level_design_two.design_pattterns.creational.factory;

import low_level_design_two.design_pattterns.creational.factory.components.buttons.Button;

public class Client {
    public static void main(String[] args) {
        Platform platform = new Android();
        //Runtime polymorphism
        Button button = platform.createButton();
    }
}
