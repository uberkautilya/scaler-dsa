package low_level_design_two.design_pattterns.behavioral;

public class GoogleMaps {
    void findPath(String source, String destination, TravelMode mode) {
        if (mode.equals(TravelMode.BIKE)) {
            PathStrategy strategy = new BikePathStrategy();
            strategy.findPath(source, destination);
        } else if (mode.equals(TravelMode.CAR)) {
            PathStrategy strategy = new CarPathStrategy();
            strategy.findPath(source, destination);
        } else {
            PathStrategy strategy = new WalkPathStrategy();
            strategy.findPath(source, destination);
        }
    }
}
