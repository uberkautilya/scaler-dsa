package low_level_design_two.design_pattterns.factory;

import low_level_design_two.design_pattterns.factory.components.buttons.AndroidButton;
import low_level_design_two.design_pattterns.factory.components.buttons.Button;

public class Android extends Platform{
    @Override
    Button createButton() {
        return new AndroidButton();
    }
}
