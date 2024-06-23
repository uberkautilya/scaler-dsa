package low_level_design_two.design_pattterns.creational.factory;

import low_level_design_two.design_pattterns.creational.factory.components.buttons.Button;

public abstract class Platform {
    String platform;
    void setRefreshRate() {

    }
    void setTheme() {

    }
    abstract Button createButton();
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
