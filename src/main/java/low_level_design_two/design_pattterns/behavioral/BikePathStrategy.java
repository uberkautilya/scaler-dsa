package low_level_design_two.design_pattterns.behavioral;

public class BikePathStrategy implements PathStrategy {
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Bike");
    }
}