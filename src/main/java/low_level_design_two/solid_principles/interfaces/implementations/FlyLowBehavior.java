package low_level_design_two.solid_principles.interfaces.implementations;

import low_level_design_two.solid_principles.interfaces.FlyBehavior;

public class FlyLowBehavior implements FlyBehavior {
    @Override
    public void makeFly() {
        System.out.println("Fly Low");
    }
}
