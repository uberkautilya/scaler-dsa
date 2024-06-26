package low_level_design_two.design_pattterns.structural.decorator;

public class HouseBlend implements Beverage{
    @Override
    public void gatDesc() {
        System.out.println("HouseBlend Beverage. Cost: " + getCost());
    }

    @Override
    public int getCost() {
        return 75;
    }
}
