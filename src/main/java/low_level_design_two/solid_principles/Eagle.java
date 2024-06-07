package low_level_design_two.solid_principles;

import low_level_design_two.solid_principles.interfaces.FlyBehavior;
import low_level_design_two.solid_principles.interfaces.implementations.FlyHighBehavior;
import low_level_design_two.solid_principles.interfaces.Flyable;

public class Eagle extends  Bird implements Flyable {

    @Override
    public void fly() {
        //Dependency inversion: Instead of tightly coupling to class behavior, we depend only on a interface
        FlyBehavior flyBehavior = new FlyHighBehavior();
        //This could have been improved with a dependency injection in a constructor argument
        flyBehavior.makeFly();
    }
}
