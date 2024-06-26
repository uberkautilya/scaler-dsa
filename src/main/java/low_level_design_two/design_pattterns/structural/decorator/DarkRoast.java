package low_level_design_two.design_pattterns.structural.decorator;

public class DarkRoast implements Beverage{
    @Override
    public void gatDesc() {
        System.out.println("Dark Roast Beverage. Cost: " + getCost());
    }

    @Override
    public int getCost() {
        return 100;
    }
}
