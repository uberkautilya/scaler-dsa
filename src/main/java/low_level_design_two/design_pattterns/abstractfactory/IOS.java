package low_level_design_two.design_pattterns.abstractfactory;

import low_level_design_two.design_pattterns.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.abstractfactory.buttons.IOSButton;
import low_level_design_two.design_pattterns.abstractfactory.factories.Factory;
import low_level_design_two.design_pattterns.abstractfactory.factories.IOSFactory;

public class IOS extends Platform {
    @Override
    Factory createComponentFactory() {
        return new IOSFactory();
    }
}
