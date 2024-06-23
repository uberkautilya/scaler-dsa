package low_level_design_two.design_pattterns.creational.abstractfactory;

import low_level_design_two.design_pattterns.creational.abstractfactory.factories.Factory;
import low_level_design_two.design_pattterns.creational.abstractfactory.factories.PlatformFactory;

public abstract class Platform {

    public static Platform getPlatform(String platformName) {
        return PlatformFactory.createPlatform(platformName);
    }

    void setRefreshRate() {

    }

    void setTheme() {

    }

    //To change from a normal Factory to an Abstract Factory pattern
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
    //Evolution 1: Runtime Polymorphism - Factory: Replace the if else conditions by moving the createButton to within the Platform implementations, which can return the appropriate Button
    //Evolution 2: Get factory based on type - Abstract Factory: When there are many such components, even this approach introduces complexity into Implementations of Platform
    // In such case, the platform implementation will only define a method that returns an appropriate factory that can then produce the components specific to the platform
}
