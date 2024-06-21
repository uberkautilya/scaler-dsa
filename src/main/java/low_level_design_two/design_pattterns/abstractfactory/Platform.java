package low_level_design_two.design_pattterns.abstractfactory;

import low_level_design_two.design_pattterns.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.abstractfactory.factories.Factory;

public abstract class Platform {
    String platform;
    void setRefreshRate() {

    }
    void setTheme() {

    }
    abstract Factory createComponentFactory();
//    Button createButton() {
//        if (platform.equals("Windows")) {
//            //create windows button
//        } else if (platform.equals("Linux")) {
//            //create linux button
//        } else if (platform.equals("Android")) {
//            //create android button
//        }
//        return new Button() {
//            @Override
//            protected Object clone() throws CloneNotSupportedException {
//                return super.clone();
//            }
//        };
//    }
}
