package low_level_design_two.design_pattterns.factory;

import low_level_design_two.design_pattterns.factory.components.buttons.Button;
import low_level_design_two.design_pattterns.factory.components.buttons.IOSButton;

public class IOS extends Platform{
    @Override
    Button createButton() {
        return new IOSButton();
    }
}
