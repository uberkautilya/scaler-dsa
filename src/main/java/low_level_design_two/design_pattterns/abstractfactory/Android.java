package low_level_design_two.design_pattterns.abstractfactory;

import low_level_design_two.design_pattterns.abstractfactory.factories.AndroidFactory;
import low_level_design_two.design_pattterns.abstractfactory.factories.Factory;

public class Android extends Platform {
    @Override
    Factory createComponentFactory() {
        return new AndroidFactory();
    }
}
