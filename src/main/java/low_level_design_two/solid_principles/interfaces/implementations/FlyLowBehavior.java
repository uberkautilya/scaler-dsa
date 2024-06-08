package low_level_design_two.solid_principles.interfaces.implementations;

import low_level_design_two.solid_principles.interfaces.FlyBehavior;

/**
 * <pre>
 * Example of code in documentation
 * {@code
 * Stream.of("one", "two", "three", "four")
 *     .filter(e -> e.length() > 3)
 *     .peek(e -> System.out.println("Filtered value: " + e))
 *     .map(String::toUpperCase)
 *     .peek(e -> System.out.println("Mapped value: " + e))
 *     .collect(Collectors.toList());
 * }
 * </pre>
 */
public class FlyLowBehavior implements FlyBehavior {
    @Override
    public void makeFly() {
        System.out.println("Fly Low");
    }
}
