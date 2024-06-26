package low_level_design_two.design_pattterns.structural.decorator;

import low_level_design_two.design_pattterns.structural.decorator.addons.Milk;
import low_level_design_two.design_pattterns.structural.decorator.addons.Mocha;

public class Client {
    public static void main(String[] args) {
        Beverage b = new DarkRoast();

        b = new Milk(b);
        b = new Mocha(b);
        b = new Mocha(b);
        b = new Mocha(b);
        b = new Milk(b);

        b.gatDesc();
    }
}
