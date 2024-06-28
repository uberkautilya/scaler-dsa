package low_level_design_two.design_pattterns.behavioral.strategy;

public class PathStrategyFactory {
    public static PathStrategy getPathStrategy(TravelMode mode) {
        PathStrategy strategy = null;
        if (mode == TravelMode.BIKE) {
            strategy = new BikePathStrategy();
        } else if (mode == TravelMode.CAR) {
            strategy = new CarPathStrategy();
        } else if (mode == TravelMode.WALK) {
            strategy = new WalkPathStrategy();
        }
        return strategy;
    }
}
