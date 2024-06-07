package low_level_design_two.solid_principles;

import low_level_design_two.solid_principles.interfaces.FlyBehavior;
import low_level_design_two.solid_principles.interfaces.implementations.FlyLowBehavior;
import low_level_design_two.solid_principles.interfaces.Flyable;

public class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        FlyBehavior flyBehavior = new FlyLowBehavior();
        flyBehavior.makeFly();
    }
}
