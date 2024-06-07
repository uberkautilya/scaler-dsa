package low_level_design_two.solid_principles;

import low_level_design_two.solid_principles.interfaces.FlyBehavior;
import low_level_design_two.solid_principles.interfaces.implementations.FlyHighBehavior;
import low_level_design_two.solid_principles.interfaces.Flyable;

public class Vulture implements Flyable {
    @Override
    public void fly() {
        FlyBehavior flyBehavior = new FlyHighBehavior();
        flyBehavior.makeFly();
    }
}
