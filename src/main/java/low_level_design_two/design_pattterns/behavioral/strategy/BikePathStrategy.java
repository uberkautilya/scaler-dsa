package low_level_design_two.design_pattterns.behavioral.strategy;

public class BikePathStrategy implements PathStrategy {
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Bike");
    }
}
