package low_level_design_two.design_pattterns.creational.factory;

import low_level_design_two.design_pattterns.creational.factory.components.buttons.AndroidButton;
import low_level_design_two.design_pattterns.creational.factory.components.buttons.Button;

public class Android extends Platform{
    @Override
    Button createButton() {
        return new AndroidButton();
    }
}
