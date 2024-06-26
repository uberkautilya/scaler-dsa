package low_level_design_two.design_pattterns.structural.decorator.addons;

import low_level_design_two.design_pattterns.structural.decorator.Beverage;

public class Milk implements AddOn{
    Beverage b;

    public Milk(Beverage b) {
        this.b = b;
    }

    @Override
    public void gatDesc() {
        System.out.println("Milk: " + getCost());
        b.gatDesc();
    }

    @Override
    public int getCost() {
        return 12 + b.getCost();
    }
}
