package low_level_design_two.design_pattterns.behavioral.strategy;

public class CarPathStrategy implements PathStrategy {
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Car");
    }
}
