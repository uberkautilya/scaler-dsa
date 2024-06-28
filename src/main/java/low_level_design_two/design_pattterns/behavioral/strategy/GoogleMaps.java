package low_level_design_two.design_pattterns.behavioral.strategy;

public class GoogleMaps {
    void findPath(String source, String destination, TravelMode mode) {
        PathStrategy strategy = PathStrategyFactory.getPathStrategy(mode);
        strategy.findPath(source, destination);
    }
}
