package low_level_design_two.solid_principles;

import low_level_design_two.solid_principles.interfaces.FlyBehavior;
import low_level_design_two.solid_principles.interfaces.Flyable;

public class Pigeon extends Bird implements Flyable {

    //Top level abstraction - not bother about the behavior implementation
    FlyBehavior flyBehavior;

    //Dependency injection
    Pigeon(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    @Override
    public void fly() {
        //Dependency Inversion: Just change the behavior brought in by the concrete class - new FlyLowBehavior() can be swapped with another
        flyBehavior.makeFly();
    }
}
