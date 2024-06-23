package low_level_design_two.design_pattterns.creational.abstractfactory;

import low_level_design_two.design_pattterns.creational.abstractfactory.factories.Factory;
import low_level_design_two.design_pattterns.creational.abstractfactory.factories.IOSFactory;

public class IOS extends Platform {
    @Override
    Factory createComponentFactory() {
        return new IOSFactory();
    }
}
