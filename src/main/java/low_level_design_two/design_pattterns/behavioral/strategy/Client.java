package low_level_design_two.design_pattterns.behavioral.strategy;

public class Client {
    public static void main(String[] args) {
        GoogleMaps googleMaps = new GoogleMaps();
        googleMaps.findPath("Kerala", "New Delhi", TravelMode.CAR);
    }
}
